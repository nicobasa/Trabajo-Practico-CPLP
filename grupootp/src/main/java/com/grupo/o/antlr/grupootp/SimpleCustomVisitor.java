package com.grupo.o.antlr.grupootp;

public class SimpleCustomVisitor extends SimpleBaseVisitor<Value> {
    private final SymbolTable symbolTable = new SymbolTable();

    @Override
    public Value visitProgram(SimpleParser.ProgramContext ctx) {
        for (SimpleParser.SentenceContext sentence : ctx.sentence()) {
            visit(sentence);
        }
        return null;
    }

    @Override
    public Value visitBlock(SimpleParser.BlockContext ctx) {
        for (SimpleParser.SentenceContext sentence : ctx.sentence()) {
            visit(sentence);
        }
        return null;
    }

    @Override
    public Value visitVar_decl(SimpleParser.Var_declContext ctx) {
        String name = ctx.ID().getText();
        Value initialValue;
        ValueType declaredType;

        if (ctx.expression() != null) {
            initialValue = visit(ctx.expression());
        } else {
            initialValue = null;
        }

        if (ctx.type() != null) {
            declaredType = readType(ctx.type());
        } else if (initialValue != null) {
            declaredType = initialValue.getType();
        } else {
            declaredType = ValueType.INT;
        }

        if (initialValue == null) {
            initialValue = Value.defaultFor(declaredType);
        }

        symbolTable.declare(name, declaredType, initialValue);
        return null;
    }

    @Override
    public Value visitVar_assign(SimpleParser.Var_assignContext ctx) {
        String name = ctx.ID().getText();
        Value value = visit(ctx.expression());
        symbolTable.assign(name, value);
        return null;
    }

    @Override
    public Value visitPrintln(SimpleParser.PrintlnContext ctx) {
        Value value = visit(ctx.expression());
        System.out.println(value.printable());
        return null;
    }

    @Override
    public Value visitConditional(SimpleParser.ConditionalContext ctx) {
        Value condition = visit(ctx.expression());
        requireBool(condition, "La condicion del if debe ser booleana");

        if (condition.asBool()) {
            visit(ctx.block(0));
        } else {
            visit(ctx.block(1));
        }
        return null;
    }

    @Override
    public Value visitFor_loop(SimpleParser.For_loopContext ctx) {
        visit(ctx.init);

        while (true) {
            Value condition = visit(ctx.condition);
            requireBool(condition, "La condicion del for debe ser booleana");

            if (!condition.asBool()) {
                break;
            }

            visit(ctx.block());
            visit(ctx.update);
        }

        return null;
    }

    @Override
    public Value visitFor_init(SimpleParser.For_initContext ctx) {
        String name = ctx.ID().getText();
        Value value = visit(ctx.expression());

        if (ctx.VAR() != null) {
            ValueType type;

            if (ctx.type() != null) {
                type = readType(ctx.type());
            } else {
                type = value.getType();
            }

            symbolTable.declare(name, type, value);
        } else {
            symbolTable.assign(name, value);
        }

        return null;
    }

    @Override
    public Value visitFor_update(SimpleParser.For_updateContext ctx) {
        String name = ctx.ID().getText();
        Value value = visit(ctx.expression());
        symbolTable.assign(name, value);
        return null;
    }

    @Override
    public Value visitExpression(SimpleParser.ExpressionContext ctx) {
        return visit(ctx.logic_or());
    }

    @Override
    public Value visitLogic_or(SimpleParser.Logic_orContext ctx) {
        Value result = visit(ctx.logic_and(0));

        for (int i = 1; i < ctx.logic_and().size(); i++) {
            requireBool(result, "El operador || requiere booleanos");
            Value right = visit(ctx.logic_and(i));
            requireBool(right, "El operador || requiere booleanos");
            result = Value.ofBool(result.asBool() || right.asBool());
        }

        return result;
    }

    @Override
    public Value visitLogic_and(SimpleParser.Logic_andContext ctx) {
        Value result = visit(ctx.equality(0));

        for (int i = 1; i < ctx.equality().size(); i++) {
            requireBool(result, "El operador && requiere booleanos");
            Value right = visit(ctx.equality(i));
            requireBool(right, "El operador && requiere booleanos");
            result = Value.ofBool(result.asBool() && right.asBool());
        }

        return result;
    }

    @Override
    public Value visitEquality(SimpleParser.EqualityContext ctx) {
        Value result = visit(ctx.comparison(0));

        for (int i = 1; i < ctx.comparison().size(); i++) {
            String operator = ctx.getChild(2 * i - 1).getText();
            Value right = visit(ctx.comparison(i));

            if (operator.equals("==")) {
                result = Value.ofBool(equalsValue(result, right));
            } else if (operator.equals("!=")) {
                result = Value.ofBool(!equalsValue(result, right));
            } else {
                throw new SemanticException("Operador de igualdad no reconocido: " + operator);
            }
        }

        return result;
    }

    @Override
    public Value visitComparison(SimpleParser.ComparisonContext ctx) {
        Value result = visit(ctx.additive(0));

        for (int i = 1; i < ctx.additive().size(); i++) {
            String operator = ctx.getChild(2 * i - 1).getText();
            Value right = visit(ctx.additive(i));

            requireNumeric(result, "El operador " + operator + " requiere numeros");
            requireNumeric(right, "El operador " + operator + " requiere numeros");

            double leftNumber = result.asReal();
            double rightNumber = right.asReal();

            switch (operator) {
                case ">":
                    result = Value.ofBool(leftNumber > rightNumber);
                    break;
                case "<":
                    result = Value.ofBool(leftNumber < rightNumber);
                    break;
                case ">=":
                    result = Value.ofBool(leftNumber >= rightNumber);
                    break;
                case "<=":
                    result = Value.ofBool(leftNumber <= rightNumber);
                    break;
                default:
                    throw new SemanticException("Operador relacional no reconocido: " + operator);
            }
        }

        return result;
    }

    @Override
    public Value visitAdditive(SimpleParser.AdditiveContext ctx) {
        Value result = visit(ctx.multiplicative(0));

        for (int i = 1; i < ctx.multiplicative().size(); i++) {
            String operator = ctx.getChild(2 * i - 1).getText();
            Value right = visit(ctx.multiplicative(i));

            if (operator.equals("+")) {
                result = add(result, right);
            } else if (operator.equals("-")) {
                result = subtract(result, right);
            } else {
                throw new SemanticException("Operador aritmetico no reconocido: " + operator);
            }
        }

        return result;
    }

    @Override
    public Value visitMultiplicative(SimpleParser.MultiplicativeContext ctx) {
        Value result = visit(ctx.unary(0));

        for (int i = 1; i < ctx.unary().size(); i++) {
            String operator = ctx.getChild(2 * i - 1).getText();
            Value right = visit(ctx.unary(i));

            if (operator.equals("*")) {
                result = multiply(result, right);
            } else if (operator.equals("/")) {
                result = divide(result, right);
            } else {
                throw new SemanticException("Operador aritmetico no reconocido: " + operator);
            }
        }

        return result;
    }

    @Override
    public Value visitUnary(SimpleParser.UnaryContext ctx) {
        if (ctx.NOT() != null) {
            Value value = visit(ctx.unary());
            requireBool(value, "El operador ! requiere un booleano");
            return Value.ofBool(!value.asBool());
        }

        if (ctx.MINUS() != null) {
            Value value = visit(ctx.unary());
            requireNumeric(value, "El operador unario - requiere un numero");
            if (value.getType() == ValueType.INT) {
                return Value.ofInt(-value.asInt());
            }
            return Value.ofReal(-value.asReal());
        }

        return visit(ctx.primary());
    }

    @Override
    public Value visitPrimary(SimpleParser.PrimaryContext ctx) {
        if (ctx.NUMBER() != null) {
            return Value.ofInt(Integer.parseInt(ctx.NUMBER().getText()));
        }

        if (ctx.REAL_NUMBER() != null) {
            return Value.ofReal(Double.parseDouble(ctx.REAL_NUMBER().getText()));
        }

        if (ctx.STRING() != null) {
            return Value.ofString(parseStringLiteral(ctx.STRING().getText()));
        }

        if (ctx.BOOLEAN() != null) {
            return Value.ofBool(Boolean.parseBoolean(ctx.BOOLEAN().getText()));
        }

        if (ctx.ID() != null) {
            return symbolTable.get(ctx.ID().getText());
        }

        return visit(ctx.expression());
    }

    private ValueType readType(SimpleParser.TypeContext ctx) {
        String text = ctx.getText();
        if (text.equals("int")) {
            return ValueType.INT;
        }
        if (text.equals("real")) {
            return ValueType.REAL;
        }
        if (text.equals("string")) {
            return ValueType.STRING;
        }
        if (text.equals("bool")) {
            return ValueType.BOOL;
        }
        throw new SemanticException("Tipo desconocido: " + text);
    }

    private Value add(Value left, Value right) {
        if (left.getType() == ValueType.STRING || right.getType() == ValueType.STRING) {
            return Value.ofString(left.printable() + right.printable());
        }
        requireNumeric(left, "El operador + requiere numeros o strings");
        requireNumeric(right, "El operador + requiere numeros o strings");

        if (left.getType() == ValueType.INT && right.getType() == ValueType.INT) {
            return Value.ofInt(left.asInt() + right.asInt());
        }
        return Value.ofReal(left.asReal() + right.asReal());
    }

    private Value subtract(Value left, Value right) {
        requireNumeric(left, "El operador - requiere numeros");
        requireNumeric(right, "El operador - requiere numeros");

        if (left.getType() == ValueType.INT && right.getType() == ValueType.INT) {
            return Value.ofInt(left.asInt() - right.asInt());
        }
        return Value.ofReal(left.asReal() - right.asReal());
    }

    private Value multiply(Value left, Value right) {
        requireNumeric(left, "El operador * requiere numeros");
        requireNumeric(right, "El operador * requiere numeros");

        if (left.getType() == ValueType.INT && right.getType() == ValueType.INT) {
            return Value.ofInt(left.asInt() * right.asInt());
        }
        return Value.ofReal(left.asReal() * right.asReal());
    }

    private Value divide(Value left, Value right) {
        requireNumeric(left, "El operador / requiere numeros");
        requireNumeric(right, "El operador / requiere numeros");

        if (right.asReal() == 0.0) {
            throw new SemanticException("Division por cero");
        }

        return Value.ofReal(left.asReal() / right.asReal());
    }

    private boolean equalsValue(Value left, Value right) {
        if (left.isNumeric() && right.isNumeric()) {
            return Double.compare(left.asReal(), right.asReal()) == 0;
        }

        if (left.getType() != right.getType()) {
            return false;
        }

        return left.getRawValue().equals(right.getRawValue());
    }

    private void requireNumeric(Value value, String message) {
        if (!value.isNumeric()) {
            throw new SemanticException(message + ". Se obtuvo " + value.getType());
        }
    }

    private void requireBool(Value value, String message) {
        if (value.getType() != ValueType.BOOL) {
            throw new SemanticException(message + ". Se obtuvo " + value.getType());
        }
    }

    private String parseStringLiteral(String text) {
        String content = text.substring(1, text.length() - 1);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < content.length(); i++) {
            char current = content.charAt(i);
            if (current == '\\' && i + 1 < content.length()) {
                char next = content.charAt(++i);
                switch (next) {
                    case 'n':
                        result.append('\n');
                        break;
                    case 't':
                        result.append('\t');
                        break;
                    case 'r':
                        result.append('\r');
                        break;
                    case '"':
                        result.append('"');
                        break;
                    case '\\':
                        result.append('\\');
                        break;
                    default:
                        result.append(next);
                        break;
                }
            } else {
                result.append(current);
            }
        }

        return result.toString();
    }
}

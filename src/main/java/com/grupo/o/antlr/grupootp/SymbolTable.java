package com.grupo.o.antlr.grupootp;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, Variable> variables = new HashMap<String, Variable>();

    public void declare(String name, ValueType type, Value value) {
        if (variables.containsKey(name)) {
            throw new SemanticException("La variable '" + name + "' ya fue declarada");
        }
        variables.put(name, new Variable(type, castToType(name, type, value)));
    }

    public void assign(String name, Value value) {
        Variable variable = variables.get(name);
        if (variable == null) {
            throw new SemanticException("La variable '" + name + "' no fue declarada");
        }
        variable.setValue(castToType(name, variable.getType(), value));
    }

    public Value get(String name) {
        Variable variable = variables.get(name);
        if (variable == null) {
            throw new SemanticException("La variable '" + name + "' no fue declarada");
        }
        return variable.getValue();
    }

    public boolean isDeclared(String name) {
        return variables.containsKey(name);
    }

    private Value castToType(String name, ValueType expectedType, Value value) {
        if (value.getType() == expectedType) {
            return value;
        }

        if (expectedType == ValueType.REAL && value.getType() == ValueType.INT) {
            return Value.ofReal(value.asReal());
        }

        throw new SemanticException(
                "Tipo incompatible para '" + name + "'. Se esperaba " + expectedType + " y se obtuvo " + value.getType());
    }
}

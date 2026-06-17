package com.grupo.o.antlr.grupootp;

public class Value {
    private final ValueType type;
    private final Object value;

    private Value(ValueType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public static Value ofInt(int value) {
        return new Value(ValueType.INT, value);
    }

    public static Value ofReal(double value) {
        return new Value(ValueType.REAL, value);
    }

    public static Value ofString(String value) {
        return new Value(ValueType.STRING, value);
    }

    public static Value ofBool(boolean value) {
        return new Value(ValueType.BOOL, value);
    }

    public static Value defaultFor(ValueType type) {
        switch (type) {
            case INT:
                return ofInt(0);
            case REAL:
                return ofReal(0.0);
            case STRING:
                return ofString("");
            case BOOL:
                return ofBool(false);
            default:
                throw new SemanticException("Tipo no soportado: " + type);
        }
    }

    public ValueType getType() {
        return type;
    }

    public Object getRawValue() {
        return value;
    }

    public int asInt() {
        if (type != ValueType.INT) {
            throw new SemanticException("Se esperaba un entero, pero se obtuvo " + type);
        }
        return (Integer) value;
    }

    public double asReal() {
        if (type == ValueType.INT) {
            return ((Integer) value).doubleValue();
        }
        if (type == ValueType.REAL) {
            return (Double) value;
        }
        throw new SemanticException("Se esperaba un numero, pero se obtuvo " + type);
    }

    public boolean asBool() {
        if (type != ValueType.BOOL) {
            throw new SemanticException("Se esperaba un booleano, pero se obtuvo " + type);
        }
        return (Boolean) value;
    }

    public String asString() {
        if (type != ValueType.STRING) {
            throw new SemanticException("Se esperaba un string, pero se obtuvo " + type);
        }
        return (String) value;
    }

    public boolean isNumeric() {
        return type == ValueType.INT || type == ValueType.REAL;
    }

    public String printable() {
        if (type == ValueType.REAL) {
            double number = (Double) value;
            if (number == Math.rint(number)) {
                return String.format(java.util.Locale.US, "%.1f", number);
            }
            return Double.toString(number);
        }
        return String.valueOf(value);
    }

    @Override
    public String toString() {
        return printable();
    }
}

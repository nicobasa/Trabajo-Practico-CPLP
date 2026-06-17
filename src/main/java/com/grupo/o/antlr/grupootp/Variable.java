package com.grupo.o.antlr.grupootp;

public class Variable {
    private final ValueType type;
    private Value value;

    public Variable(ValueType type, Value value) {
        this.type = type;
        this.value = value;
    }

    public ValueType getType() {
        return type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}

package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.Visitor;

public class Variable implements Function {
    private final String name;
    private final Double value;

    public Variable(String name, double value) {
        this.name = name;
        this.value = value;
    }
    public Variable(double value) {
        this.name = null;
        this.value = value;
    }
    public Variable(String name) {
        this.name = name;
        this.value = null;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitVariable(this);
    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

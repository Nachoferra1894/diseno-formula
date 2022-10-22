package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.Visitor;

public class MonoOperation implements Function{
    private final Function arg;
    private final MonoOperator operator;

    public MonoOperation(Function arg, MonoOperator operator) {
        this.arg = arg;
        this.operator = operator;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitMonoOperation(this);
    }

    public Function getArg() {
        return arg;
    }

    public MonoOperator getOperator() {
        return operator;
    }
}

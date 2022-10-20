package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.Visitor;

public class Operation implements Function{
    private final Function firstArg;
    private final Function secondArg;
    private final Operator operator;

    public Operation(Function firstArg, Function secondArg, Operator operator) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.operator = operator;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitOperation(this);
    }

    public Function getFirstArg() {
        return firstArg;
    }

    public Function getSecondArg() {
        return secondArg;
    }

    public Operator getOperator() {
        return operator;
    }
}

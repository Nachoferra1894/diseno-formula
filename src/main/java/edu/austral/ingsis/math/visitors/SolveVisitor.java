package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.*;

public class SolveVisitor implements Visitor{
    Double result;
    EquationResolver equationResolver = new EquationResolver();

    @Override
    public void visitOperation(Operation operation) {
        Operator operator = operation.getOperator();
        double fArg = getResult(operation.getFirstArg());
        double sArg = getResult(operation.getSecondArg());

        result = equationResolver.getResultFromOperator(fArg,sArg,operator);
    }

    private double getResult(Function function) {
        function.acceptVisitor(this);
        return result;
    }

    @Override
    public void visitVariable(Variable variable) {
        result = variable.getValue();
    }

    @Override
    public void visitMonoOperation(MonoOperation monoOp) {
        MonoOperator operator = monoOp.getOperator();
        double arg = getResult(monoOp.getArg());
        result = equationResolver.getMonoResultFromOperator(arg,operator);
    }

    public Double getResult() {
        return result;
    }
}

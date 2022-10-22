package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.*;

public class PrintVisitor implements Visitor{
    String result;
    @Override
    public void visitOperation(Operation operation) {
        Operator monoOperator = operation.getOperator();
        Function fstArg = operation.getFirstArg();
        Function sndArg = operation.getSecondArg();

        if (fstArg.isComposite()){
            result = "(" + getString(fstArg) + ")";
        } else result = getString(fstArg);

        result += monoOperator;

        if (sndArg.isComposite()){
            result += "(" + getString(sndArg) + ")";
        } else result = getString(sndArg);
    }

    @Override
    public void visitVariable(Variable variable) {
        Double value = variable.getValue();
        String name = variable.getName();

        if (value != null){
            result = String.valueOf(value);
        } else result = name;
    }

    @Override
    public void visitMonoOperation(MonoOperation monoOp) {
        MonoOperator monoOperator = monoOp.getOperator();
        String argString = getString(monoOp.getArg());

        switch (monoOperator) {
            case ABS:
                result = monoOperator + argString + monoOperator;
            case SQR:
                result = monoOperator + "(" + argString + ")";
            default:
                throw new UnsupportedOperationException("The operator is not correct!");
        }
    }

    private String getString(Function function) {
        function.acceptVisitor(this);
        return this.result;
    }
}

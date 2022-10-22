package edu.austral.ingsis.math;

public class EquationResolver {
    public double getResultFromOperator(double firstValue, double secondValue, Operator operator){
        switch (operator) {
            case SUM:
                return firstValue + secondValue;
            case SUB:
                return firstValue - secondValue;
            case MUL:
                return firstValue * secondValue;
            case DIV:
                return firstValue / secondValue;
            case EXP:
                return Math.pow(firstValue, secondValue);
            default:
                throw new UnsupportedOperationException("The operator is not correct!");
        }
    }

    public Double getMonoResultFromOperator(double arg, MonoOperator operator) {
        switch (operator) {
            case ABS:
                return Math.abs(arg);
            case SQR:
                return Math.sqrt(arg);
            default:
                throw new UnsupportedOperationException("The operator is not correct!");
        }
    }
}

package edu.austral.ingsis.math;

public enum Operator {
    SUM("+"),
    SUB("-"),
    MUL("*"),
    DIV("/"),
    EXP("^");

    public final String label;

    private Operator(String label) {
        this.label = label;
    }
}

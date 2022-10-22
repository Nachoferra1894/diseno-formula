package edu.austral.ingsis.math;

public enum MonoOperator {
    SQR("sqrt"),
    ABS("|");

    public final String label;

    private MonoOperator(String label) {
        this.label = label;
    }
}

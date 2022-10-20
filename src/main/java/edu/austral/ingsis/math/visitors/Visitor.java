package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.MonoOperation;
import edu.austral.ingsis.math.Operation;
import edu.austral.ingsis.math.Variable;

public interface Visitor {
    void visitOperation(Operation operation);
    void visitVariable(Variable variable);
    void visitMonoOperation(MonoOperation monoOp);
}

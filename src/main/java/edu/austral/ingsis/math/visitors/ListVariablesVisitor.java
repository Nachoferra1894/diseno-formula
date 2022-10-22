package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.MonoOperation;
import edu.austral.ingsis.math.Operation;
import edu.austral.ingsis.math.Variable;

import java.util.LinkedList;
import java.util.List;

public class ListVariablesVisitor implements Visitor {
    List<String> variables = new LinkedList<>();

    @Override
    public void visitOperation(Operation operation) {
        operation.getFirstArg().acceptVisitor(this);
        operation.getSecondArg().acceptVisitor(this);
    }

    @Override
    public void visitVariable(Variable variable) {
        if (variable.getName() != null) variables.add(variable.getName());
    }

    @Override
    public void visitMonoOperation(MonoOperation monoOp) {
        monoOp.getArg().acceptVisitor(this);
    }

    public List<String> getVariables() {
        return variables;
    }
}

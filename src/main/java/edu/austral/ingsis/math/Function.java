package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.Visitor;

public interface Function {
    boolean isComposite();
    void acceptVisitor(Visitor visitor);
}

package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.ListVariablesVisitor;
import edu.austral.ingsis.math.visitors.Visitor;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Function op = new Operation(new Variable(1), new Variable(6), Operator.SUM);

        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Function op = new Operation(new Variable(12), new Variable("div"), Operator.DIV);

        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Function firstTerm = new Operation(new Variable(9), new Variable("x"), Operator.DIV);
        Function op = new Operation(firstTerm,new Variable("y"),Operator.MUL);

        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Function firstTerm = new Operation(new Variable(27), new Variable("a"), Operator.DIV);
        Function op = new Operation(firstTerm,new Variable("b"),Operator.EXP);

        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Function secondTerm = new Operation(new Variable(1), new Variable(1), Operator.DIV);
        Function op = new Operation(new Variable("z"),secondTerm,Operator.EXP);

        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Function firstTerm = new MonoOperation(new Variable("value"),MonoOperator.ABS);
        Function op = new Operation(firstTerm,new Variable(8),Operator.SUB);

        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Function firstTerm = new Operation(new Variable(5), new Variable("i"), Operator.SUB);
        Function op = new Operation(firstTerm,new Variable(8),Operator.MUL);

        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}

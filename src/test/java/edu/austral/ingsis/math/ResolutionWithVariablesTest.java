package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.SolveVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Function op = new Operation(new Variable(1), new Variable("x",3), Operator.SUM);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Function op = new Operation(new Variable(12), new Variable("div",4), Operator.DIV);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Function firstArg = new Operation(new Variable(9), new Variable("x",3), Operator.DIV);
        Function op = new Operation(firstArg, new Variable("y",4), Operator.MUL);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Function firstArg = new Operation(new Variable(27), new Variable("a",9), Operator.DIV);
        Function op = new Operation(firstArg, new Variable("b",3), Operator.EXP);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Function secondTerm = new Operation(new Variable(1), new Variable(2), Operator.DIV);
        Function op = new Operation(new Variable("z",36),secondTerm,Operator.EXP);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Function firstArg = new MonoOperation(new Variable("value",8), MonoOperator.ABS);
        Function op = new Operation(firstArg, new Variable(8), Operator.SUB);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();


        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = -8
     */
    @Test
    public void shouldResolveFunction7() {
        Function firstArg = new MonoOperation(new Variable("value",-8), MonoOperator.ABS);
        Function op = new Operation(firstArg, new Variable(8), Operator.SUB);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Function firstArg = new Operation(new Variable(5),new Variable("i",2), Operator.SUB);
        Function op = new Operation(firstArg, new Variable(8), Operator.MUL);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(24d));
    }
}

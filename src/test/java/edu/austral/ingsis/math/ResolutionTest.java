package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.PrintVisitor;
import edu.austral.ingsis.math.visitors.SolveVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Function op = new Operation(new Variable(1), new Variable(6), Operator.SUM);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Function op = new Operation(new Variable(12), new Variable(2), Operator.DIV);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final String expected = "(9 / 2) * 3";
        Function firstArg = new Operation(new Variable(9), new Variable(2), Operator.DIV);
        Function op = new Operation(firstArg, new Variable(3), Operator.MUL);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final String expected = "(27 / 6) ^ 2";
        Function firstArg = new Operation(new Variable(27), new Variable(6), Operator.DIV);
        Function op = new Operation(firstArg, new Variable(2), Operator.EXP);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Function secondTerm = new Operation(new Variable(1), new Variable(2), Operator.DIV);
        Function op = new Operation(new Variable(36),secondTerm,Operator.EXP);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Function op = new MonoOperation(new Variable(136),MonoOperator.ABS);
        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Function op = new MonoOperation(new Variable(-136),MonoOperator.ABS);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();


        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Function firstTerm = new Operation(new Variable(5), new Variable(5), Operator.SUB);
        Function op = new Operation(firstTerm,new Variable(8),Operator.EXP);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(0d));
    }
}

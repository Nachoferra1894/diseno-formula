package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.ListVariablesVisitor;
import edu.austral.ingsis.math.visitors.PrintVisitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        Function op = new Operation(new Variable(1), new Variable(6), Operator.SUM);

        PrintVisitor printVisitor = new PrintVisitor();
        op.acceptVisitor(printVisitor);

        final String result = printVisitor.getResult();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        Function op = new Operation(new Variable(12), new Variable(2), Operator.DIV);

        PrintVisitor printVisitor = new PrintVisitor();
        op.acceptVisitor(printVisitor);

        final String result = printVisitor.getResult();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        Function firstArg = new Operation(new Variable(9), new Variable(2), Operator.DIV);
        Function op = new Operation(firstArg, new Variable(3), Operator.MUL);

        PrintVisitor printVisitor = new PrintVisitor();
        op.acceptVisitor(printVisitor);

        final String result = printVisitor.getResult();


        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        Function firstArg = new Operation(new Variable(27), new Variable(6), Operator.DIV);
        Function op = new Operation(firstArg, new Variable(2), Operator.EXP);

        PrintVisitor printVisitor = new PrintVisitor();
        op.acceptVisitor(printVisitor);

        final String result = printVisitor.getResult();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        Function firstArg = new MonoOperation(new Variable("value"), MonoOperator.ABS);
        Function op = new Operation(firstArg, new Variable(8), Operator.SUB);

        PrintVisitor printVisitor = new PrintVisitor();
        op.acceptVisitor(printVisitor);

        final String result = printVisitor.getResult();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        Function firstArg = new Operation(new Variable(5),new Variable("i"), Operator.SUB);
        Function op = new Operation(firstArg, new Variable(8), Operator.MUL);

        PrintVisitor printVisitor = new PrintVisitor();
        op.acceptVisitor(printVisitor);

        final String result = printVisitor.getResult();

        assertThat(result, equalTo(expected));
    }
}

import org.example.DataModels.Polynomial;
import org.example.Operations.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
    Operation op = new Operation();
    Polynomial p1;
    Polynomial p2;

    @org.junit.jupiter.api.Test
    public void addPolynomialTestPass() throws Exception {
        p1 = new Polynomial("x^2-5x+7");
        p2 = new Polynomial("-3x^2-x");
        Polynomial result = Operation.additional(p1, p2);
        Polynomial expectedResult = new Polynomial("-2x^2-6x+7");
        assertEquals(expectedResult.toString(), result.toString());

    }

    @org.junit.jupiter.api.Test
    public void addPolynomialTestFail() throws Exception {
        p1 = new Polynomial("x^3+4x^2-7");
        p2 = new Polynomial("-9x^4-7x^2-x");
        Polynomial result = Operation.additional(p1, p2);
        Polynomial expectedResult = new Polynomial("-2x^2-6x+7");
        assertEquals(expectedResult.toString(), result.toString());

    }

    @org.junit.jupiter.api.Test
    public void subPolynomialTestPass() throws Exception {
        p1 = new Polynomial("x^3+4x^2-7");
        p2 = new Polynomial("-9x^4-7x^2-x");
        Polynomial result = Operation.substraction(p1, p2);
        Polynomial expectedResult = new Polynomial("9x^4+x^3+11x^2+x-7");
        assertEquals(expectedResult.toString(), result.toString());

    }

    @org.junit.jupiter.api.Test
    public void subPolynomialTestFail() throws Exception {
        p1 = new Polynomial("x^3+4x^2-7");
        p2 = new Polynomial("-9x^4-7x^2-x");
        Polynomial result = Operation.substraction(p1, p2);
        Polynomial expectedResult = new Polynomial("-2x^2-6x+7");
        assertEquals(expectedResult.toString(), result.toString());

    }

    @org.junit.jupiter.api.Test
    public void derivPolynomialTestPass() throws Exception {
        p1 = new Polynomial("x^3+4x^2-7");
        Polynomial result = Operation.derivative(p1);
        Polynomial expectedResult = new Polynomial("3x^2+8x");
        assertEquals(expectedResult.toString(), result.toString());

    }

    @org.junit.jupiter.api.Test
    public void derivPolynomialTestFail() throws Exception {
        p1 = new Polynomial("x^3+4x^2-7");
        Polynomial result = Operation.derivative(p1);
        Polynomial expectedResult = new Polynomial("-2x^2-6x+7");
        assertEquals(expectedResult.toString(), result.toString());

    }

    @org.junit.jupiter.api.Test
    public void integrationPolynomialTestPass() throws Exception {
        p1 = new Polynomial("16x^3-9x^2-15");
        Polynomial result = Operation.integrate(p1);
        Polynomial expectedResult = new Polynomial("4x^4-3x^3-15x");
        assertEquals(expectedResult.toString(), result.toString());

    }

    @org.junit.jupiter.api.Test
    public void integrationPolynomialTestFail() throws Exception {
        p1 = new Polynomial("16x^3-9x^2-15");
        Polynomial result = Operation.integrate(p1);
        Polynomial expectedResult = new Polynomial("-2x^2-6x+7");
        assertEquals(expectedResult.toString(), result.toString());

    }

    @org.junit.jupiter.api.Test
    public void multiplyPolynomialTestPass() throws Exception {
        p1 = new Polynomial("2x^2+5");
        p2 = new Polynomial("3x+2");
        Polynomial result = Operation.multiplication(p1, p2);
        Polynomial expectedResult = new Polynomial("6x^3+4x^2+15x+10");
        assertEquals(expectedResult.toString(), result.toString());

    }

    @org.junit.jupiter.api.Test
    public void multiplyPolynomialTestFail() throws Exception {
        p1 = new Polynomial("2x^2+5");
        p2 = new Polynomial("3x+2");
        Polynomial result = Operation.multiplication(p1, p2);
        Polynomial expectedResult = new Polynomial("6x^3+4x^2");
        assertEquals(expectedResult.toString(), result.toString());

    }

}

package Example;

import Example.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void createNewCalculator()
    {
        calculator = new Calculator();
    }

    @Test
    public void shouldSumIntPositive() {
        int a = 1;
        int b = 1;
        int expected = 2; // ожидание
        int actual = calculator.sumInt(a,b); //фактический
        assertEquals("1+1 должно равняться 2", expected, actual);
    }

    @Test
    public void shouldSumDoubleNegative() {
        double a = 1.50;
        double b = 0.50;
        double delta = 0.05;
        double expected = 1.94; // ожидание
        double actual = calculator.sumDouble(a,b); //фактический
        assertEquals("1.50+0.50 должно равняться 2 (допустимая погрешность 0.05)", expected, actual, delta);
    }

    @Test
    public void shouldSumIntNegative() {
        int a = 1;
        int b = 0;
        int unexpected = 0; // ожидание
        int actual = calculator.sumInt(a,b); //фактический
        assertNotEquals("1+0 должно отличаться от 0", unexpected, actual);
    }

    @After
    public void deleteOutputFile() {

    }
}
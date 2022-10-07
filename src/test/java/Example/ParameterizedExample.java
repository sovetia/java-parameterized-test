package Example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) // указали, что тесты будет запускать раннер Parameterized
public class ParameterizedExample {

    private final int firstNumber;
    private final int secondNumber;
    private final int expected;
    Calculator calculator;

    private int actual;

    // Создать конструктор
    public ParameterizedExample(int firstNumber, int secondNumber, int expected) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expected = expected;
    }

    //Заполняем Тестовые данные (int firstNumber, int secondNumber, int expected)
    @Parameterized.Parameters
    public static Object getSum() {
        return new Object[][] {
                {1,9,10}, //Верно для суммы/НЕверно умножение
                {-1,0,0}, //НЕверно для суммы/Верно умножение
                {2,2,4},  //Верно для суммы/Верно умножение
        };
    }

    @Before // Предусловия для всех тестов
    public void checkNewCalculator() {
        calculator = new Calculator();
    }

    @Test // Проверяем сложение
    public void testCalculatorSumInt() {
        actual = calculator.sumInt(firstNumber,secondNumber);
    }

    @Test // Проверяем умножение
    public void testCalculatorMulti() {
        actual = calculator.mult(firstNumber,secondNumber);
    }

    @After // Результат проверки для всех тестов
    public void checkTest() {
        assertEquals("Сумма неверна",expected,actual);
    }
}

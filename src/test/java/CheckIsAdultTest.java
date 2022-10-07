import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CheckIsAdultTest {
private final int age;
private final boolean expected;

public  CheckIsAdultTest(int age, boolean expected) {
    this.age = age;
    this.expected = expected;
}

@Parameterized.Parameters
    public static Object getTestData() {
    return new Object[][] {
            {19, true},
            {17,false},
            {18,true},
            {21,true},
            {-21,false},
    };
}

@Test
    public void checkIsAdultWhenAgeThenResult(){
    CheckIsAdult program = new CheckIsAdult();
    boolean isAdult = program.checkIsAdult(age);
    assertEquals("Возраст определен неверно", expected, isAdult);
}

}
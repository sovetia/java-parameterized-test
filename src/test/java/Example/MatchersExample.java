package Example;

import org.junit.Test;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.*;

public class MatchersExample {

    @Test //Матчер containsString проверяет, содержит ли одна строка другую:
    public void testMatcherContainsString() {
        String actual = "Java"; // проверяемая строка
        String jSign = "av"; // строка, которая должна входить в проверяемую
        MatcherAssert.assertThat("Error:", actual, containsString(jSign));
    }

    @Test //Матчер startsWith проверяет, начинается ли одна строка с другой:
    public void testMatcherStartsWith() {
        String actual = "Java";
        String jSign = "Ja";
        MatcherAssert.assertThat(actual, startsWith(jSign));
    }

    @Test //Матчер endsWith проверяет, заканчивается ли одна строка другой:
    public void testMatcherEndsWith() {
        String actual = "Java";
        String vaLetters = "va";
        MatcherAssert.assertThat(actual, endsWith(vaLetters));
    }

    @Test //Матчер allOf проверяет, что аргумент метода assertThat соответствует всем условиям — матчерам-аргументам метода allOf:
    public void testMatcherAllOf() {
        String actual = "Java";
        String JSign = "J";
        String vaLetters = "va";
        MatcherAssert.assertThat(actual, allOf(containsString(vaLetters), startsWith(JSign)));
        // проверили сразу два условия с матчерами containsString и startsWith
    }

    @Test //Матчер anyOf проверяет, что аргумент метода assertThat соответствует хотя бы одному условию — матчеру-аргументу метода anyOf:
    public void testMatcherAnyOf() {
        String actual = "Java";
        String JSign = "J";
        String vaLetters = "va";
        MatcherAssert.assertThat(actual, anyOf(endsWith(vaLetters), startsWith(JSign)));
    }

    @Test //Матчер notNullValue() проверяет, что аргумент метода assertThat — не null-значение:
    public void testMatcherNotNullValue() {
        String actual = "Java";
        MatcherAssert.assertThat(actual, notNullValue());
    }

    @Test //Матчер is проверяет, что один аргумент является другим:
    public void testMatcherIs() {
        MatcherAssert.assertThat(10, is(10));
    }

    @Test //Матчер not — логическое отрицание другого матчера:
    public void testMatcherNot() {
        MatcherAssert.assertThat(10, is(not(11)));
    }



}

package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {

    SomeService someService;
    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }


    // 3.1.
    @Test
    void multipleThreeNotFiveReturnsFizz() {
        assertEquals("Fizz", someService.fizzBuzz(6));
    }

    @Test
    void multipleFiveNotThreeReturnsBuzz() {
        assertEquals("Buzz", someService.fizzBuzz(10));
    }

    @Test
    void multipleFiveteenReturnsFizzBuzz() {
        assertEquals("FizzBuzz", someService.fizzBuzz(30));
    }

    @Test
    void notMultipleReturnsNum() {
        assertEquals("31", someService.fizzBuzz(31));
    }

    // 3.2.
    @Test
    void lastNumberlsSixReturnTrue() {
        int[] myArray = new int[]{1, 0, 1, 6};
        assertTrue(someService.firstLast6(myArray));
    }

    @Test
    void firstLastNumberNotSixReturnFalse() {
        int[] myArray = new int[] {1, 0, 1, 3};
        assertFalse(someService.firstLast6(myArray));
    }

    @Test
    void firstNumberlsSixReturnTrue() {
        int[] myArray = new int[] {6, 0, 1, 4};
        assertTrue(someService.firstLast6(myArray));
    }

    // 3.3.
    @ParameterizedTest
    @CsvSource({"2000.0, 50, 1000", "2000.0, 100, 0", "2000.0, 0, 2000"}) // подстановка наборов данных в метод
    void paramTest1(Double p, int d, int e){
        assertThat(someService.calculatingDiscount(p, d))
                .isEqualTo(e);
    }

    @ParameterizedTest
    @CsvSource({"2000.0, 101", "2000.0, -10"}) // подстановка наборов данных в метод
    void paramTest2(Double p, int d){
        assertThatThrownBy(() ->
                someService.calculatingDiscount(p, d))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }

    // 3.4.
    @Test
    void testLuckySum1() {
        assertEquals(6, someService.luckySum(1, 2, 3));
    }

    @Test
    void testLuckySum2() {
        assertEquals(5, someService.luckySum(13, 2, 3));
    }

    @Test
    void testLuckySum3() {
        assertEquals(3, someService.luckySum(1, 2, 13));
    }

}
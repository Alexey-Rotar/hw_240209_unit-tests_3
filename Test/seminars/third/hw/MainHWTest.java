package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {

    MainHW mainHW;
    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    // HW 3.1.
    @Test
    void evenOddNumberTrueTest() {
        assertTrue(mainHW.evenOddNumber(2));
    }

    @Test
    void evenOddNumberFalseTest() {
        assertFalse(mainHW.evenOddNumber(3));
    }

    // HW 3.2.
    @Test
    void numberInIntervalTrueTest1() {
        assertTrue(mainHW.numberInInterval(26));
    }

    @Test
    void numberInIntervalTrueTest2() {
        assertTrue(mainHW.numberInInterval(99));
    }

    @Test
    void numberInIntervalFalseTest1() {
        assertFalse(mainHW.numberInInterval(100));
    }

    @Test
    void numberInIntervalFalseTest2() {
        assertFalse(mainHW.numberInInterval(25));
    }

    @Test
    void numberInIntervalFalseTest3() {
        assertFalse(mainHW.numberInInterval(-4));
    }
}

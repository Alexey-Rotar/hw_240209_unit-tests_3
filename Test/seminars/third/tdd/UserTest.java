package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    User user;
    @BeforeEach
    void setUp() {
        user = new User("Lex", "taxi", false);
    }

    @Test
    void authenticateTrueTest() {
        assertTrue(user.authenticate("Lex", "taxi"));
    }

    @Test
    void authenticateFalseTest1() {
        assertFalse(user.authenticate("Bear", "taxi"));
    }

    @Test
    void authenticateFalseTest2() {
        assertFalse(user.authenticate("Lex", "moto"));
    }

}
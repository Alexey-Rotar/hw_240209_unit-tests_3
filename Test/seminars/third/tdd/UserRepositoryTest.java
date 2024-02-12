package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {

    UserRepository userRepository;
    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        // заполнение данных обо всех пользователях в системе
        userRepository.data.add(new User("Lex", "taxi", false));
        userRepository.data.add(new User("Plu", "push", false));
        userRepository.data.add(new User("Galaxy", "admin", true));
        userRepository.data.add(new User("Passenger", "moneymaker", false));
    }

    @Test
    void addUserTrueTest() {
        // попытка входа в систему - всё верно
        userRepository.addUser(new User("Plu", "push"));

        assertTrue(userRepository.data.get(1).isAuthenticate());
    }

    @Test
    void addUserFalseTest1() {
        // попытка входа в систему - имя верное, пароль нет
        userRepository.addUser(new User("Galaxy", "user"));

        assertFalse(userRepository.data.get(2).isAuthenticate());
    }

    @Test
    void addUserFalseTest2() {
        // попытка входа в систему - имя не верное, пароль верный
        userRepository.addUser(new User("Devil", "admin"));

        assertFalse(userRepository.data.get(2).isAuthenticate());
    }

    @Test
    void unloginAllUsersTest0() {
        userRepository.unloginAllUsers();

        // обычный пользователь, он должен разлогиниться
        assertTrue(userRepository.data.get(0).isAuthenticate());
    }

    @Test
    void unloginAllUsersTest1() {
        userRepository.unloginAllUsers();

        // обычный пользователь, он должен разлогиниться
        assertTrue(userRepository.data.get(1).isAuthenticate());
    }

    @Test
    void unloginAllUsersTest2() {
        userRepository.unloginAllUsers();

        // админ, он НЕ должен разлогиниться
        assertFalse(userRepository.data.get(2).isAuthenticate());
    }

    @Test
    void unloginAllUsersTest3() {
        userRepository.unloginAllUsers();

        // обычный пользователь, он должен разлогиниться
        assertTrue(userRepository.data.get(3).isAuthenticate());
    }

}

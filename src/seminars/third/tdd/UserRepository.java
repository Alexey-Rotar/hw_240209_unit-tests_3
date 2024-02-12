package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        // если пользователь есть в базе и он прошел аутентификацию
        if (findByName(user.getName())) {
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).getName().equals(user.getName()) && data.get(i).getPassword().equals(user.getPassword()))
                    data.get(i).setAuthenticate(true);     // помечаем его как аутентифицированного
            }
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void unloginAllUsers() {
        for (User user : data) {
            if (!user.isAdmin()) {
                user.setAuthenticate(true);
            }
        }
    }

}
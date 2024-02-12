package seminars.third.tdd;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;

    boolean isAdmin = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAuthenticate(boolean authenticate) {
        isAuthenticate = authenticate;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        if (name.equals(this.name) && password.equals(this.password))
            return true;
        else
            return false;
    }

}
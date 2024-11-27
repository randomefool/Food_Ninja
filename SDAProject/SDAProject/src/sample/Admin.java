package sample;

public class Admin {

    private String Username,Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Admin(String username, String password) {
        Username = username;
        Password = password;
    }
}

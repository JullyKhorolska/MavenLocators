public class Login {
    String userName;
    String password;
    String passwordError;
    String url;

    public Login(String userName, String password, String passwordError,String url) {
        this.userName = userName;
        this.password = password;
        this.passwordError = passwordError;
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;    }

    @Override
    public String toString() {
        return "Login{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", passworderror='" + passwordError + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }
}

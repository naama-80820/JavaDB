package entities;

public class LoginDetails {
    private String UserName;
    private String PassWord;

    public LoginDetails(String userName, String passWord) {
        UserName = userName;
        PassWord = passWord;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}

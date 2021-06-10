package model;

public class UserDTO {
    private int userNumber;
    private String userId;
    private String password;
    private String nickName;
    private int grade;

    
    public int getUserNumber() {
        return userNumber;
    }
    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
 
    
    public boolean equals(Object o) {
        if(o instanceof UserDTO) {
            UserDTO u = (UserDTO)o;
            if(userId.equals(u.userId)) {
//                if(userNumber == u.userNumber) {
                return true;
            }
        }
        return false;
    }
}

package controller;

import java.util.ArrayList;
import model.UserDTO;

public class UserController {
    private ArrayList<UserDTO> list;
    private int userNumber;

    public UserController() {
        list = new ArrayList<>();
        userNumber = 1;

        UserDTO u = new UserDTO();
        u.setUserNumber(userNumber++);
        u.setUserId("김은비");
        u.setPassword("1221");
        u.setNickName("은비짱");
        u.setGrade(3);
        list.add(u);
        u = new UserDTO();
        u.setUserNumber(userNumber++);
        u.setUserId("이한경");
        u.setPassword("0926");
        u.setNickName("한경짱");
        u.setGrade(2);
        list.add(u);

        u = new UserDTO();
        u.setUserNumber(userNumber++);
        u.setUserId("이경진");
        u.setPassword("0127");
        u.setNickName("경진짱");
        u.setGrade(1);
        list.add(u);

        System.out.println(list.size());
    }

    public void add(UserDTO u) {
        u.setUserNumber(userNumber++);

        list.add(u);
    }

    public boolean validateUserId(String user) {
        for (UserDTO u : list) {
            if (u.getUserId().equals(user)) {
                return true;
            }

        }
        return false;
    }

    /** 로그인 시 사용 */
    public UserDTO auth(UserDTO user) {
        for (UserDTO u : list) {
            if (u.getUserId().equals(user.getUserId()) && u.getPassword().equals(user.getPassword())) {
                return u;
            }
        }
        return null;
    }

//    public UserDTO  checkAdmin() {
//        for (UserDTO u : list) {
//            if (u.getGrade() == 3) {
//                return u;
//            }
//        }
//        return null; m
//    }


}
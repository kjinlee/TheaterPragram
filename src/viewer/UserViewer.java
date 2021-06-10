package viewer;

import java.util.Scanner;
import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

public class UserViewer {
    private UserController controller;
    private Scanner sc;
    private UserDTO logIn;
    private final int ADMIN = 3;
    
    public UserViewer() {
        controller = new UserController();
        sc = new Scanner(System.in);
        logIn = null;
    }

    public void register() {
        UserDTO u = new UserDTO();
        String msg;
        msg = "1. 일반고객\n2. 평론가";
        int choice = ScannerUtil.nextInt(sc, msg, 1, 2);
        u.setGrade(choice);

        msg = "사용하실 아이디를 입력해주세요.";
        String id = ScannerUtil.nextLine(sc, msg);

        while (controller.validateUserId(id)) {
            System.out.println("중복된 아이디입니다.");
            msg = "사용하실 아이디를 다시 입력해주세요.";
            id = ScannerUtil.nextLine(sc, msg);
        }

        u.setUserId(id);

        msg = "사용하실 비밀번호를 입력해주세요.";
        u.setPassword(ScannerUtil.nextLine(sc, msg));

        msg = "사용하실 닉네임을 입력해주세요.";
        u.setNickName(ScannerUtil.nextLine(sc, msg));

        controller.add(u);

    }

    public boolean logIn() {
        while (true) {
            UserDTO u = new UserDTO();
            String msg;

            msg = "아이디를 입력해주세요.";
            u.setUserId(ScannerUtil.nextLine(sc, msg));

            msg = " 비밀번호를 입력해주세요.";
            u.setPassword(ScannerUtil.nextLine(sc, msg));

            UserDTO result = controller.auth(u);

            while (result == null) {
                System.out.println("잘못된 아이디/비밀번호 입니다.");
                msg = "다시 시도하시겠습니까?\n y/n";
                String userChoice = ScannerUtil.nextLine(sc, msg);
                if (!userChoice.equalsIgnoreCase("y")) {
                    return false;
                }

                msg = "아이디를 다시 입력해주세요.";
                u.setUserId(ScannerUtil.nextLine(sc, msg));

                msg = "비밀번호를 다시 입력해주세요.";
                u.setPassword(ScannerUtil.nextLine(sc, msg));

                result = controller.auth(u);
            }

            logIn = result;
            return true;
        }

    }
    
    public boolean checkAdmin() {
        if (logIn.getGrade() == ADMIN) {
            return true;
        }
        
        return false;
    }

}
package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.TheaterController;
import model.MovieDTO;
import model.TheaterDTO;
import util.ScannerUtil;

public class TheaterViewer {
    private TheaterController controller;
    private MovieViewer movieViewer;
    private UserViewer userViewer;
    private InfoViewer infoViewer;
    private Scanner sc;

    public TheaterViewer(UserViewer userViewer, MovieViewer movieViewer, InfoViewer infoViewer) {
        controller = new TheaterController();
        this.userViewer = userViewer;
        this.movieViewer = movieViewer;
        this.infoViewer = infoViewer;
        sc = new Scanner(System.in);
    }

    public void printList() {
        ArrayList<TheaterDTO> list = controller.printAll();
        System.out.println("=============================");
        System.out.println("        LLK영화관 지점안내        ");
        System.out.println("=============================");
        for (TheaterDTO t : list) {
            System.out.printf("%d. %s\n", t.getTheaterNumber(), t.getTheaterName());
        }
        System.out.println("=============================");

        printUserMenu();
    }
    
    
    
    public void printTheaterName() {
        ArrayList<TheaterDTO> list = controller.printAll();
        System.out.println("=============================");
        System.out.println("        LLK영화관 지점안내        ");
        System.out.println("=============================");
        for (TheaterDTO t : list) {
            System.out.printf("%d. %s\n", t.getTheaterNumber(), t.getTheaterName());
        }
        System.out.println("=============================");
        
    }
    

    public void printTheaterOne(int theaterNumber) {
        TheaterDTO t = controller.selectOne(theaterNumber);
        System.out.println("=============================");
        System.out.printf("극장 번호 : %d번\n극장이름 : %s\n장소 : %s\n극장전화번호 : %s\n", t.getTheaterNumber(), t.getTheaterName(),
                t.getLocation(), t.getPhone());
        System.out.println("=============================");

    }

    public void printUserMenu() {
        ArrayList<TheaterDTO> list = controller.printAll();
        String msg;
        msg = "LLK의 지점을 선택해주세요.(0.뒤로가기)";
        int userChoice = ScannerUtil.nextInt(sc, msg, 0, list.size());
        if (!(userChoice == 0)) {
            msg = "1. 상영 정보\n2. 지점 정보\n3. 뒤로가기";
            int menuChoice = ScannerUtil.nextInt(sc, msg, 1, 2);
            if (menuChoice == 1) {
                movieViewer.printMovieName(infoViewer.selectListByTheater(userChoice));

            } else if (menuChoice == 2) {
                // 2. 지점 정보
                printTheaterOne(userChoice);

            } else if (menuChoice == 3) {
                System.out.println("메뉴로 돌아갑니다.");

            }
        } else {
            System.out.println("메뉴로 돌아갑니다.");
        }
    }


    public void printAdminMenu() {
        ArrayList<TheaterDTO> list = controller.printAll();
        String msg;
        msg = "1. 새 영화관 등록하기\n2. 영화관 정보 수정하기\n3. 영화관 삭제하기\n4. 뒤로가기";
        int adminChoice = ScannerUtil.nextInt(sc, msg, 1, 4);
        if (adminChoice == 1) {
            printAdd();
        } else if (adminChoice == 2) {
            // 수정할 영화 목록 보여주기
            msg = "수정할 영화관 지점 번호를 입력해주세요.(0.뒤로가기)";
            adminChoice = ScannerUtil.nextInt(sc, msg, 0, list.size());
            if (!(adminChoice == 0)) {
                printUpdate(adminChoice);
            } else {

            }
        } else if (adminChoice == 3) {
            // 삭제할 영화 목록 보여주기
            msg = "삭제할 영화관 지점 번호를 입력해주세요.(0.뒤로가기)";
            adminChoice = ScannerUtil.nextInt(sc, msg, 0, list.size());
            if (!(adminChoice == 0)) {
                printDelete(adminChoice);
            } else {

            }
        } else {
            System.out.println("메뉴로 돌아갑니다.");
        }
    }

    public void printAdd() {
        TheaterDTO temp = new TheaterDTO();
        String msg;

        msg = "새로 등록할 극장의 이름을 입력해주세요.";
        temp.setTheaterName(ScannerUtil.nextLine(sc, msg));

        msg = "새로 등록할 극장의 위치를 입력해주세요.";
        temp.setLocation(ScannerUtil.nextLine(sc, msg));

        msg = "새로 등록할 극장의 전화번호를 입력해주세요.";
        temp.setPhone(ScannerUtil.nextLine(sc, msg));

        controller.add(temp);
    }

    public void printUpdate(int theaterNumber) {
        TheaterDTO t = controller.selectOne(theaterNumber);
        TheaterDTO temp = new TheaterDTO();
        temp.setTheaterNumber(t.getTheaterNumber());
        String msg;

        msg = "극장 이름을 수정해주세요.\\n(수정을 원하시지 않으면 N을 입력해주세요.)";
        temp.setTheaterName(ScannerUtil.nextLine(sc, msg));

        msg = "극장 위치를 수정해주세요.\\n(수정을 원하시지 않으면 N을 입력해주세요.)";
        temp.setLocation(ScannerUtil.nextLine(sc, msg));

        msg = "극장 전화번호를 수정해주세요.\\n(수정을 원하시지 않으면 N을 입력해주세요.)";
        temp.setPhone(ScannerUtil.nextLine(sc, msg));

        controller.update(temp);
    }

    public void printDelete(int theaterNumber) {
        TheaterDTO t = controller.selectOne(theaterNumber);
        if (t.getTheaterNumber() == theaterNumber) {
            String msg;
            msg = "정말 삭제하시겠습니까?\n(Y: 네  N: 아니오)";
            String input = ScannerUtil.nextLine(sc, msg);
            if (input.equalsIgnoreCase("y")) {
                controller.delete(t);
            } else {

            }
        }
    }
}

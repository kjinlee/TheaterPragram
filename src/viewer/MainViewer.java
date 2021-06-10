package viewer;

import java.util.Scanner;

import util.ScannerUtil;

public class MainViewer {
    private UserViewer userViewer;
    private MovieViewer movieViewer;
    private TheaterViewer theaterViewer;
    private RatingViewer ratingViewer;
    private InfoViewer infoViewer;
    private Scanner sc;
    private String line;

    public MainViewer() {
        userViewer = new UserViewer();
        ratingViewer = new RatingViewer(userViewer, movieViewer);
        infoViewer = new InfoViewer();
        movieViewer = new MovieViewer(userViewer, ratingViewer, infoViewer);
        theaterViewer = new TheaterViewer(userViewer, movieViewer, infoViewer);
        sc = new Scanner(System.in);
        line = "=============================";
    }

    public void showIndex() {
        while (true) {
            System.out.println(line);
            System.out.println("      LLK 영화관 로그인      ");
            System.out.println(line);
            String msg;
            msg = "1. 로그인\n2. 회원가입\n3. 종료";
            int userChoice = ScannerUtil.nextInt(sc, msg);
            if (userChoice == 1) {
                if (userViewer.logIn()) {
                    if (userViewer.checkAdmin()) {
                        showAdminMenu();
                    } else {
                        showUserMenu();
                    }
                } else {

                }
            } else if (userChoice == 2) {
                userViewer.register();

            } else if (userChoice == 3) {
                System.out.println("★LLK를 사용해주셔서 감사합니다.★");
                break;
            }
        }

    }

    public void showUserMenu() {
        while (true) {
            String msg;
            System.out.println(line);
            System.out.println("      ★LLK CINEMA★     ");
            System.out.println(line);
            msg = "1. 영화 메뉴\n2. 영화관 메뉴\n3. 뒤로가기";

            int userChoice = ScannerUtil.nextInt(sc, msg, 1, 3);
            if (userChoice == 1) {
                // 1. 영화메뉴
                movieViewer.printMovieAll();

            } else if (userChoice == 2) {
                // 2. 영화관
                theaterViewer.printList();

            } else if (userChoice == 3) {
                // 상영정보
                System.out.println("로그인 화면으로 돌아갑니다.");
                break;
            }

        }
    }

    public void showAdminMenu() {
        while (true) {
            String msg;
            msg = "1. 영화 정보 관리\n2. 극장 정보 관리\n3. 상영 정보 관리\n4. 뒤로가기";
            int userChoice = ScannerUtil.nextInt(sc, msg, 1, 4);
            if (userChoice == 1) {
                movieViewer.printAdminMenu();

            } else if (userChoice == 2) {
                theaterViewer.printAdminMenu();

            } else if (userChoice == 3) {
                msg = "1. 상영정보 등록하기\n2. 상영정보 수정하기\n3. 상영정보 삭제하기\n4. 뒤로가기";
                int menuChoice = ScannerUtil.nextInt(sc, msg);
                if (menuChoice == 1) {
                    showAdminAdd();
                    
                } else if (menuChoice == 2) {
                    // 수정하기
                 
                } else if (menuChoice == 3) {
                    // 삭제하기
                    showAdminDelete();
                } else if (menuChoice == 4) {
                    System.out.println("메뉴로 돌아갑니다.");
                }
            } else if (userChoice == 4) {
                System.out.println("로그인 화면으로 돌아갑니다.");
                break;
            }

        }
    }

    public void showAdminAdd() {
        String msg;
        theaterViewer.printTheaterName();
        msg = "상영정보를 등록할 영화관을 선택해주세요.";
        int theaterId = ScannerUtil.nextInt(sc, msg);
        movieViewer.printMovieName();
        msg = "상영정보를 등록할 영화제목을 선택해주세요.";
        int movieId = ScannerUtil.nextInt(sc, msg);
        infoViewer.printAdd(theaterId, movieId); // 보기주기 주기
    }
    
    public void showAdminDelete() {
        String msg;
        theaterViewer.printTheaterName();
        msg = "상영정보를 삭제할 영화관을 선택해주세요.";
        int theaterNum = ScannerUtil.nextInt(sc, msg);
        movieViewer.printMovieName(infoViewer.selectListByTheater(theaterNum));
        
        msg = "상영정보를 삭제할 상영관 번호를 입력해주세요.";
        int infoNum = ScannerUtil.nextInt(sc, msg);
        infoViewer.printDelete(theaterNum, infoNum); // 보기주기 주기
    }
    
    
    
}

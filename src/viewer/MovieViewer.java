package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.MovieController;
import model.InfoDTO;
import model.MovieDTO;
import model.RatingDTO;
import model.UserDTO;
import util.ScannerUtil;

public class MovieViewer {
    private MovieController controller;
    private Scanner sc;
    private UserViewer userViewer;
    private RatingViewer ratingViewer;
    private InfoViewer infoViewer;

    public MovieViewer(UserViewer userViewer, RatingViewer ratingViewer, InfoViewer infoViewer) {
        this.userViewer = userViewer;
        this.ratingViewer = ratingViewer;
        this.infoViewer = infoViewer;

        controller = new MovieController();
        sc = new Scanner(System.in);
    }

    public void printMovieAll() {
        ArrayList<MovieDTO> list = controller.printAll();

        System.out.println("=============================");
        System.out.println("        상영중인 영화 목록         ");
        System.out.println("=============================");
        for (MovieDTO m : list) {
            System.out.printf("%d. %s (%s)\n", m.getMovieNumber(), m.getMovieTitle(), m.getMovieGrade()); // + 상영시간
        }
        System.out.println("=============================");
        
        printUserMenu();
    }

    public void printMovieName() {
        ArrayList<MovieDTO> list = controller.printAll();

        System.out.println("=============================");
        System.out.println("        상영중인 영화 목록         ");
        System.out.println("=============================");
        for (MovieDTO m : list) {
            System.out.printf("%d. %s\n", m.getMovieNumber(), m.getMovieTitle()); // + 상영시간

        }

        System.out.println("=============================");

    }

    public void printUserMenu() {
        ArrayList<MovieDTO> list = controller.printAll();
        String msg;
        msg = "상세보기 할 영화를 선택해주세요.(0.뒤로가기)";
        int userChoice = ScannerUtil.nextInt(sc, msg, 0, list.size());
        if (!(userChoice == 0)) {
            msg = "1. 상영시간표\n2. 영화 정보\n3. 뒤로가기";
            int menuChoice = ScannerUtil.nextInt(sc, msg, 1, 2);
            if (menuChoice == 1) {
                // 1. 상영 정보
                printMovieName(userChoice);
                infoViewer.printMovie(userChoice);
            } else if (menuChoice == 2) {
                // 2. 지점 정보
                printMovieOne(userChoice);

            } else if (menuChoice == 3) {
                System.out.println("메뉴로 돌아갑니다.");

            }
        } else {
            System.out.println("메뉴로 돌아갑니다.");
        }
    }

    public void printAdminMenu() {
        ArrayList<MovieDTO> list = controller.printAll();
        String msg;
            msg = "1. 새 영화 등록하기\n2. 영화 정보 수정하기\n3. 영화 정보 삭제하기\n4. 뒤로가기";
            int adminChoice = ScannerUtil.nextInt(sc, msg, 1, 4);
            if (adminChoice == 1) {
                printAdd();
            } else if (adminChoice == 2) {
                // 수정할 영화 목록 보여주기
                msg = "수정할 영화 번호를 입력해주세요.(0.뒤로가기)";
                adminChoice = ScannerUtil.nextInt(sc, msg, 0, list.size());
                if (!(adminChoice == 0)) {
                    printUpdate(adminChoice);
                } else {

                }
            } else if (adminChoice == 3) {
                // 삭제할 영화 목록 보여주기
                msg = "삭제할 영화 번호를 입력해주세요.(0.뒤로가기)";
                adminChoice = ScannerUtil.nextInt(sc, msg, 0, list.size());
                if (!(adminChoice == 0)) {
                    printDelete(adminChoice);
                } else {

                }
            } else {
                System.out.println("메뉴로 돌아갑니다.");
        }
    }

    public void printMovieName(int movieNumber) {
        MovieDTO m = controller.selectOne(movieNumber);
        if (controller.checkMovie()) {
            System.out.println("=============================");
            System.out.printf("%d. %s\n", m.getMovieNumber(), m.getMovieTitle());
            System.out.println("=============================");
            // 평점 메소드
        } else {
            System.out.println("상영 중인 영화가 없습니다.");
        }

    }

    // infoViewer.selectListByTheater(userChoice)
    public void printMovieName(ArrayList<InfoDTO> infoList) {
        // 서초점 정보 리스트
        for (InfoDTO i : infoList) {
            MovieDTO m = controller.selectOne(i.getMovieNumber());
            System.out.println("=============================");
            System.out.printf("%d. 상영관\n", i.getInfoNumber());
            System.out.printf("☞%s (%s)\n☞상영시간: %s\n", m.getMovieTitle(), m.getMovieGrade(), i.getMovieTime());
        }
        if (controller.checkMovie()) {

            // 평점 메소드
        } else {
            System.out.println("상영 중인 영화가 없습니다.");
        }
    }

    public void printMovieOne(int movieNumber) {
        MovieDTO m = controller.selectOne(movieNumber);
        if (controller.checkMovie()) {
            System.out.println("=============================");
            System.out.printf("영화번호: %d번\n영화제목: %s\n줄거리: %s\n관람 등급: %s\n", m.getMovieNumber(), m.getMovieTitle(),
                    m.getMovieStory(), m.getMovieGrade());

            System.out.println("=============================");
            // 평점 메소드
            ratingViewer.printRate(m);

        } else {
            System.out.println("상영 중인 영화가 없습니다.");
        }

    }

    /** 뷰어용 */

    public void printAdd() {
        MovieDTO temp = new MovieDTO();
        String msg;

        msg = "새로 등록할 영화의 제목을 입력해주세요.";
        String title = ScannerUtil.nextLine(sc, msg);

        while (controller.validateTitle(title)) {
            System.out.println("이미 등록된 영화 제목입니다.");
            msg = "새로 등록할 영화의 제목을 다시 입력해주세요.";
            title = ScannerUtil.nextLine(sc, msg);
        }

        temp.setMovieTitle(title);

        msg = "새로 등록할 영화의 줄거리를 입력해주세요.";
        temp.setMovieStory(ScannerUtil.nextLine(sc, msg));

        msg = "새로 등록할 영화의 관람 등급을 입력해주세요.";
        temp.setMovieGrade(ScannerUtil.nextLine(sc, msg));

        controller.add(temp);
    }

    public void printUpdate(int movieNumber) {
        MovieDTO m = controller.selectOne(movieNumber);
        if (controller.checkHaveMovie(m)) {
            MovieDTO temp = new MovieDTO();
            temp.setMovieNumber(m.getMovieNumber());

            String msg;
            msg = "영화 제목을 수정해주세요.\n(수정을 원하시지 않으면 N을 입력해주세요.)";
            temp.setMovieTitle(ScannerUtil.nextLine(sc, msg));

            msg = "영화 줄거리를 수정해주세요.\n(수정을 원하시지 않으면 N을 입력해주세요.)";
            temp.setMovieStory(ScannerUtil.nextLine(sc, msg));

            msg = "영화 등급을 수정해주세요.\n(수정을 원하시지 않으면 N을 입력해주세요.)";
            temp.setMovieGrade(ScannerUtil.nextLine(sc, msg));

            controller.update(temp);
        } else {
            System.out.println("존재하지 않는 번호입니다.");
        }
    }

    public void printDelete(int movieNumber) {
        MovieDTO m = controller.selectOne(movieNumber);
        if (m.getMovieNumber() == movieNumber) {
            String msg;
            msg = "정말 삭제하시겠습니까?\n(Y: 네  N: 아니오)";
            String input = ScannerUtil.nextLine(sc, msg);
            if (input.equalsIgnoreCase("y")) {
                controller.delete(m);
            } else {

            }
        }
    }

}

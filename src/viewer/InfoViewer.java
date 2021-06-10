package viewer;

import java.util.ArrayList;
import java.util.Scanner;
import controller.InfoController;
import model.InfoDTO;
import model.MovieDTO;
import util.ScannerUtil;

public class InfoViewer {
    private InfoController controller;
    private Scanner sc;

    public InfoViewer() {
        controller = new InfoController();
        sc = new Scanner(System.in);

    }

    // 영화관 목록
    public void printMovie(int userChoice) {
        ArrayList<InfoDTO> list = controller.selectByMovie(userChoice);
        System.out.println("상영 시간:");
        for (InfoDTO i : list) {
            System.out.printf("%s\n", i.getMovieTime());

        }

    }

    public void printTheater(int userChoice) {
        ArrayList<InfoDTO> list = controller.selectByTheater(userChoice);
        System.out.println("상영 시간:");
        for (InfoDTO i : list) {
            System.out.printf("%s\n", i.getMovieTime());
        }

    }

    public ArrayList<InfoDTO> selectListByTheater(int theaterId) {
        return controller.selectByTheater(theaterId);
    }

    public void printAdd(int theaterNum, int movieNum) {
        InfoDTO temp = new InfoDTO();
        String msg;

        temp.setTheaterNumber(theaterNum);

        temp.setMovieNumber(movieNum);

        msg = "새로 등록할 상영 시간을 작성해주세요.";
        String movieTime = ScannerUtil.nextLine(sc, msg);

        while (controller.checkTime(movieTime)) {
            System.out.println("이미 존재하는 상영시간입니다.");
            msg = "등록할 상영 시간을 재 작성해주세요.";
            movieTime = ScannerUtil.nextLine(sc, msg);
        }

        temp.setMovieTime(movieTime);

        controller.add(temp);
    }

//    public void printUpdate(int movieNumber) {
//        InfoDTO m = controller.selectByMovie(movieNumber);
//        if (controller.checkHaveMovie(m)) {
//            MovieDTO temp = new MovieDTO();
//            temp.setMovieNumber(m.getMovieNumber());
//
//            String msg;
//            msg = "영화 제목을 수정해주세요.\n(수정을 원하시지 않으면 N을 입력해주세요.)";
//            temp.setMovieTitle(ScannerUtil.nextLine(sc, msg));
//
//            msg = "영화 줄거리를 수정해주세요.\n(수정을 원하시지 않으면 N을 입력해주세요.)";
//            temp.setMovieStory(ScannerUtil.nextLine(sc, msg));
//
//            msg = "영화 등급을 수정해주세요.\n(수정을 원하시지 않으면 N을 입력해주세요.)";
//            temp.setMovieGrade(ScannerUtil.nextLine(sc, msg));
//
//            controller.update(temp);
//        } else {
//            System.out.println("존재하지 않는 번호입니다.");
//        }
//    }

    public void printDelete(int theaterNum, int infoNum) {
        InfoDTO i = controller.selectOneByTheater(theaterNum);
        if (i.getInfoNumber() == infoNum) {
            String msg;
            msg = "정말 삭제하시겠습니까?\n(Y: 네  N: 아니오)";
            String input = ScannerUtil.nextLine(sc, msg);
            if (input.equalsIgnoreCase("y")) {
                controller.delete(i);
            } else {

            }

        }
    }

}

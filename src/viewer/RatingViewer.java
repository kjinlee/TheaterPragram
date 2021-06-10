package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.RatingController;
import model.MovieDTO;
import model.RatingDTO;
import util.ScannerUtil;

public class RatingViewer {
    private RatingController controller;
    private Scanner sc;
    private UserViewer userViewer;
    private MovieViewer movieViewer;

    public RatingViewer(UserViewer userViewer, MovieViewer movieViewer) {
        controller = new RatingController();
        sc = new Scanner(System.in);

        this.userViewer = userViewer;
        this.movieViewer = movieViewer;
    }

    public void printRate(MovieDTO m) {
        while (true) {
            ArrayList<RatingDTO> list = controller.selectMovieNum(m.getMovieNumber());
            String msg;
            msg = "1. 전체 평점 보기\n2. 일반인 리뷰 보기\n3. 평론가 리뷰 보기\n4. 뒤로가기";
            int userChoice = ScannerUtil.nextInt(sc, msg, 1, 4);
            boolean bCheck = false;
            if (userChoice == 1) {
                for (RatingDTO r : list) {
                    if (r.getUserNumber() == 1) {
                        System.out.println("=============================");
                        System.out.println("         전체 영화 평점         ");
                        System.out.println("=============================");
                        System.out.printf("☞ 관람객 평점 : %d점\n", r.getRating()); // 평균 만들기
                        bCheck = true;
                    }

                    if (r.getUserNumber() == 2) {
                        System.out.printf("☞ 평론가 평점 : %d점\n", r.getRating());
                        bCheck = true;
                    }

                }
                System.out.println("=============================");

            } else if (userChoice == 2) {
                System.out.println("=============================");
                System.out.println("         일반인 영화 리뷰         ");
                System.out.println("=============================");
                for (RatingDTO r : list) {
                    if (r.getUserNumber() == userChoice) {
                        System.out.printf("☞ 별점 : %d점\n☞ 한줄평 : %s\n", r.getRating(), r.getMovieReview());
                        bCheck = true;
                    }
                }
                System.out.println("=============================");

            } else if (userChoice == 3) {

                System.out.println("=============================");
                System.out.println("         평론가 영화 리뷰         ");
                System.out.println("=============================");
                for (RatingDTO r : list) {
                    if (r.getUserNumber() == userChoice) {
                        System.out.printf("☞ 별점 : %d점\n☞ 한줄평 : %s\n", r.getRating(), r.getMovieReview());
                        bCheck = true;
                    }
                }
                System.out.println("=============================");
            } else if (userChoice == 4) {
                System.out.println("영화 목록으로 이동합니다.");
                break;
            }

            if (!bCheck) {
                System.out.println("리뷰가 없습니다.");
            }
        }
    }

}
package controller;

import java.util.ArrayList;

import model.MovieDTO;
import model.RatingDTO;
import model.UserDTO;

public class MovieController {
    private ArrayList<MovieDTO> list;
    private int movieNumber;

    public MovieController() {
        list = new ArrayList<>();
        movieNumber = 1;

        MovieDTO m = new MovieDTO();
        m.setMovieNumber(movieNumber++);
        m.setMovieTitle("미나리");
        String msg = new String();
        msg = "2021년 전세계가 기다린 어느 한국 가족의 원더풀한 이야기";
        m.setMovieStory(msg);
        m.setMovieGrade("12세 이상");
        list.add(m);

        m = new MovieDTO();
        m.setMovieNumber(movieNumber++);
        m.setMovieTitle("최면");
        msg = new String();
        msg = "지우고 싶은 기억이 있어요? 기억의 빈틈, 진실은 그곳에 있다!!";
        m.setMovieStory(msg);
        m.setMovieGrade("15세 이상");
        list.add(m);

        m = new MovieDTO();
        m.setMovieNumber(movieNumber++);
        m.setMovieTitle("신세계");
        msg = new String();
        msg = "세 남자가 가고 싶었던 서로 다른 \"신세계\"";
        m.setMovieStory(msg);
        m.setMovieGrade("청소년 관람 불가");
        list.add(m);

        m = new MovieDTO();
        m.setMovieNumber(movieNumber++);
        m.setMovieTitle("겨울왕국");
        msg = new String();
        msg = "어느 날 부턴가 의문의 목소리가 엘사를 부르는데..!";
        m.setMovieStory(msg);
        m.setMovieGrade("전연령 관람 가능");
        list.add(m);
    }

    public void add(MovieDTO m) {
        m.setMovieNumber(movieNumber++);

        list.add(m);
    }

    public boolean validateTitle(String title) {
        for (MovieDTO m : list) {
            if (m.getMovieTitle().equals(title)) {
                return true;
            }

        }
        return false;
    }

    public MovieDTO selectOne(int movieNumber) {
        for (MovieDTO m : list) {
            if (m.getMovieNumber() == movieNumber) {
                return m;
            }
        }
        return null;
    }

    public void update(MovieDTO updated) {
        if (!updated.getMovieTitle().equalsIgnoreCase("N")) {
            // 해당 제목을 리스트의 원본 dto에 찾아서 거기 제목에 저장
            for (MovieDTO m : list) {
                if (m.getMovieNumber() == updated.getMovieNumber()) {
                    m.setMovieTitle(updated.getMovieTitle());
                    m.setMovieStory(updated.getMovieStory());
                    m.setMovieGrade(updated.getMovieGrade());
                }

            }
        }
    }

    public void delete(MovieDTO m) {
        list.remove(m);
    }

    public ArrayList<MovieDTO> printAll() {
        ArrayList<MovieDTO> temp = new ArrayList<>();
        for (MovieDTO m : list) {
            temp.add(m);

        }

        return temp;
    }

    /** 컨트롤용 */
    public MovieDTO selectOneByMovie(int movieNumber) {
        for (MovieDTO m : list) {
            if (m.getMovieNumber() == movieNumber) {
                return m;
            }
        }
        return null;
    }

    public boolean checkMovie() {
        for (MovieDTO m : list) {
            if (m.getMovieNumber() != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean checkHaveMovie(MovieDTO m) {
        return list.contains(m);
    }

}

package controller;

import java.util.ArrayList;
import model.InfoDTO;
import model.MovieDTO;

public class InfoController {
    private ArrayList<InfoDTO> list;
    private int infoNumber;
    private int movie_hour;
    private int movie_minute;

    public InfoController() {
        list = new ArrayList<>();
        infoNumber = 1;
        movie_hour = 11;
        movie_minute = 0;
        InfoDTO i = new InfoDTO();

        for (int j = 1; j < 5; j++) {
            for (int k = 1; k < 5; k++) {
                i = new InfoDTO();
                i.setTheaterNumber(j);
                i.setInfoNumber(infoNumber++);
                i.setMovieNumber(k);
                i.setMovieTime((movie_hour++) + "시" + (movie_minute += 10) + "분");
                list.add(i);
            }
        }

        movie_hour = 14;
        movie_minute = 5;
        for (int j = 1; j < 5; j++) {
            for (int k = 1; k < 5; k++) {
                i = new InfoDTO();
                i.setTheaterNumber(j);
                i.setInfoNumber(infoNumber++);
                i.setMovieNumber(k);
                i.setMovieTime((movie_hour++) + "시" + (movie_minute += 10) + "분");
                list.add(i);
            }
        }

    }

    public void add(InfoDTO i) {
        i.setInfoNumber(infoNumber++);
        list.add(i);
    }

    public boolean checkTime(String movieTime) {
        for (InfoDTO i : list) {
            if (i.getMovieTime().equals(movieTime)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<InfoDTO> selectByTheater(int theaterNum) {
        ArrayList<InfoDTO> temp = new ArrayList<>();
        for (InfoDTO i : list) {
            if (i.getTheaterNumber() == theaterNum) {
                temp.add(i);
            }
        }
        return temp;

    }

    public ArrayList<InfoDTO> selectByMovie(int movieNum) {
        ArrayList<InfoDTO> temp = new ArrayList<>();
        for (InfoDTO i : list) {
            if (i.getMovieNumber() == movieNum) {
                temp.add(i);
            }
        }
        return temp;

    }

    public InfoDTO selectOneByTheater(int theaterNum) {
        for (InfoDTO i : list) {
            if (i.getTheaterNumber() == theaterNum) {
                return i;
            }
        }
        return null;
    }

    public void delete(InfoDTO i) {
        list.remove(i);
    }

}

package controller;

import java.util.ArrayList;
import model.TheaterDTO;

public class TheaterController {
    private ArrayList<TheaterDTO> list;
    private int theaterNumber;

    public TheaterController() {
        list = new ArrayList<>();
        theaterNumber = 1;

        TheaterDTO t = new TheaterDTO();
        t.setTheaterNumber(theaterNumber++);
        t.setTheaterName("LLK 서초점");
        t.setLocation("서울특별시 서초구 서초4동 강남대로 459");
        t.setPhone("02-3486-9600");
        list.add(t);

        t = new TheaterDTO();
        t.setTheaterNumber(theaterNumber++);
        t.setTheaterName("LLK 덕소점");
        t.setLocation("경기도 남양주시 와부읍 덕소리 49-1");
        t.setPhone("02-3486-9601");
        list.add(t);

        t = new TheaterDTO();
        t.setTheaterNumber(theaterNumber++);
        t.setTheaterName("LLK 신도림점");
        t.setLocation("서울특별시 구로구 신도림동 101-7");
        t.setPhone("02-3486-9602");
        list.add(t);

        t = new TheaterDTO();
        t.setTheaterNumber(theaterNumber++);
        t.setTheaterName("LLK 강남점");
        t.setLocation("서울특별시 강남구 자곡로 180");
        t.setPhone("02-3486-9603");

        list.add(t);
    }

    public void add(TheaterDTO t) {
        t.setTheaterNumber(theaterNumber++);

        list.add(t);
    }

    public ArrayList<TheaterDTO> printAll() {
        ArrayList<TheaterDTO> temp = new ArrayList<>();
        for (TheaterDTO t : list) {
            temp.add(t);
        }
        return temp;
    }

    
    public TheaterDTO selectOne(int theaterNumber) {
        for (TheaterDTO t : list) {
            if (t.getTheaterNumber() == theaterNumber) {
                return t;
            }
        }

        return null;
    }

    
    public void update(TheaterDTO updated) {
        if (!updated.getTheaterName().equalsIgnoreCase("n")) {
            for (TheaterDTO t : list) {
                if (t.getTheaterNumber() == updated.getTheaterNumber()) {
                    t.setTheaterName(updated.getTheaterName());
                    t.setLocation(updated.getLocation());
                    t.setPhone(updated.getPhone());

                    list.add(t);
                }
            }
        }
    }

    public void delete(TheaterDTO t) {
        list.remove(t);
    }

 
}

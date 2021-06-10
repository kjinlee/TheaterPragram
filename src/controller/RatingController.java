package controller;

import java.util.ArrayList;

import model.MovieDTO;
import model.RatingDTO;

public class RatingController {
    private ArrayList<RatingDTO> list;
    private int ratingNumber;

    public RatingController() {
        list = new ArrayList<>();
        ratingNumber = 1;

        RatingDTO r = new RatingDTO();
        r.setRatingNumber(ratingNumber++);
        r.setUserNumber(1);
        r.setMovieNumber(1);
        r.setRating(4);
        r.setMovieReview("배우들의 연기가 명품이네요!");
        list.add(r);

        r = new RatingDTO();
        r.setRatingNumber(ratingNumber++);
        r.setUserNumber(2);
        r.setMovieNumber(1);
        r.setRating(3);
        r.setMovieReview("영화가 루즈했어요.");
        list.add(r);
        
        r = new RatingDTO();
        r.setRatingNumber(ratingNumber++);
        r.setUserNumber(1);
        r.setMovieNumber(2);
        r.setRating(2);
        r.setMovieReview("이걸 돈주고 봤다니.");
        list.add(r);
        
        r = new RatingDTO();
        r.setRatingNumber(ratingNumber++);
        r.setUserNumber(2);
        r.setMovieNumber(2);
        r.setRating(3);
        r.setMovieReview("기괴한 허세와 엉성한 땜질.");
        list.add(r);
        
        r = new RatingDTO();
        r.setRatingNumber(ratingNumber++);
        r.setUserNumber(1);
        r.setMovieNumber(3);
        r.setRating(5);
        r.setMovieReview("미친 연기, 미친 영화 대박!");
        list.add(r);
        
        r = new RatingDTO();
        r.setRatingNumber(ratingNumber++);
        r.setUserNumber(2);
        r.setMovieNumber(3);
        r.setRating(4);
        r.setMovieReview("매력적 캐릭터, 잘 짜인 이야기의 힘");
        list.add(r);

        r = new RatingDTO();
        r.setRatingNumber(ratingNumber++);
        r.setUserNumber(1);
        r.setMovieNumber(4);
        r.setRating(4);
        r.setMovieReview("아이들이 참 좋아했어요.");
        list.add(r);
        
        r = new RatingDTO();
        r.setRatingNumber(ratingNumber++);
        r.setUserNumber(2);
        r.setMovieNumber(4);
        r.setRating(4);
        r.setMovieReview("현실과 통하는 디즈니의 마법");
        list.add(r);
    }

    public void add(RatingDTO r) {
        r.setRatingNumber(ratingNumber++);

        list.add(r);
    }

    public ArrayList<RatingDTO> selectMovieNum(int movieNumber) {
        ArrayList<RatingDTO> temp = new ArrayList<>();
        for (RatingDTO r : list) {
            if (r.getMovieNumber() == movieNumber) {
                temp.add(r);
            }
        }

        return temp;
    }
    
//    public ArrayList<RatingDTO> selectMovieNum(int movieNumber) {
//        ArrayList<RatingDTO> temp = new ArrayList<>();
//        for (RatingDTO r : list) {
//            if (r.getMovieNumber() == movieNumber) {
//                temp.add(r);
//            }
//        }
//        
//        return temp;
//    }
    
    public ArrayList<RatingDTO> selectUserNum(int userNumber) {
        ArrayList<RatingDTO> temp = new ArrayList<>();
        for (RatingDTO r : list) {
            if (r.getMovieNumber() == userNumber) {
                temp.add(r);
            }
        }
        
        return temp;
    }

    
   
    
    
    
    
    
}

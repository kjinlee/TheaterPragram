package model;

public class RatingDTO {
    private int ratingNumber;
    private int userNumber;
    private int movieNumber;
    private int rating;
    private String movieReview;
    
    
    
    public int getRatingNumber() {
        return ratingNumber;
    }
    public void setRatingNumber(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }
    public int getUserNumber() {
        return userNumber;
    }
    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }
    public int getMovieNumber() {
        return movieNumber;
    }
    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getMovieReview() {
        return movieReview;
    }
    public void setMovieReview(String movieReview) {
        this.movieReview = movieReview;
    }
    
    
    public boolean equals(Object o) {
        if(o instanceof RatingDTO) {
            RatingDTO m = (RatingDTO)o;
            if(ratingNumber == m.ratingNumber) {
                return true;
            }
        }
        return false;
    }
}

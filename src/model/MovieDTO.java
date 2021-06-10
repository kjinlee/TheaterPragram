package model;

public class MovieDTO {
    private int movieNumber;
    private String movieTitle;
    private String movieStory;
    private String movieGrade;
    
    
    public int getMovieNumber() {
        return movieNumber;
    }
    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }
    public String getMovieTitle() {
        return movieTitle;
    }
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    public String getMovieStory() {
        return movieStory;
    }
    public void setMovieStory(String movieStory) {
        this.movieStory = movieStory;
    }
    public String getMovieGrade() {
        return movieGrade;
    }
    public void setMovieGrade(String movieGrade) {
        this.movieGrade = movieGrade;
    }
    
    
    public boolean equals(Object o) {
        if(o instanceof MovieDTO) {
            MovieDTO m = (MovieDTO)o;
            if(movieNumber == m.movieNumber) {
                return true;
            }
        }
        return false;
    }
    
}

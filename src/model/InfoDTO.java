package model;

import java.util.Calendar;

public class InfoDTO {
    private int infoNumber;
    private int movieNumber;
    private int theaterNumber;
    private String movieTime;
    
    public int getInfoNumber() {
        return infoNumber;
    }
    public void setInfoNumber(int infoNumber) {
        this.infoNumber = infoNumber;
    }
    public int getMovieNumber() {
        return movieNumber;
    }
    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }
    public int getTheaterNumber() {
        return theaterNumber;
    }
    public void setTheaterNumber(int theaterNumber) {
        this.theaterNumber = theaterNumber;
    }
    public String getMovieTime() {
        return movieTime;
    }
    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    
    public boolean equals(Object o) {
        if(o instanceof InfoDTO) {
            InfoDTO i = (InfoDTO)o;
            if(theaterNumber == i.theaterNumber) {
                return true;
            }
        }
        return false;
    }
    
    
}

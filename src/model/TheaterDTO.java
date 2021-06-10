package model;

public class TheaterDTO {
    private int theaterNumber;
    private String theaterName;
    private String location;
    private String phone;
    public int getTheaterNumber() {
        return theaterNumber;
    }
    public void setTheaterNumber(int theaterNumber) {
        this.theaterNumber = theaterNumber;
    }
    public String getTheaterName() {
        return theaterName;
    }
    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public boolean equals(Object o) {
        if(o instanceof TheaterDTO) {
            TheaterDTO t = (TheaterDTO)o;
            if(theaterNumber == t.theaterNumber) {
                return true;
            }
        }
        return false;
    }
}

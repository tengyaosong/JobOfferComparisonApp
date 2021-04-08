package edu.gatech.seclass.jobcompare6300;


public class Location {

    private String city;
    private String state;

    // constructor
    public Location(String city, String state){
        this.city = city;
        this.state = state;
    }

    // getters & setters
    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString(){
        return String.format("%s, %s", this.city, this.state);
    }
}

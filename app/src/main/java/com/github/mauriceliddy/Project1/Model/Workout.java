package com.github.mauriceliddy.Project1.Model;

public class Workout {

    private int wid;
    private String day;
    private int distance;
    private int gain;
    private double time;
    private UserAccount user;

    public Workout(){

    }

    public Workout(int wid, String day, int distance, int gain, double time, UserAccount user) {
        this.wid = wid;
        this.day = day;
        this.distance = distance;
        this.gain = gain;
        this.time = time;
        this.user = user;
    }

    
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public UserAccount getUserAccount() {
        return user;
    }

    public void setUserAccount(UserAccount user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Workout [user=" + user + ", day=" + day + ", distance=" + distance + ", gain=" + gain + ", time="
                + time + "]";
    }

    public void printWorkoutDataFromDB(){
        System.out.println("Workout:  [Workout ID: " +wid+ " athleteID: " + user.getId() + ", day=" + day + ", distance=" + distance + ", gain=" + gain + ", time="
        + time + "]");
    }
    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    
    
}

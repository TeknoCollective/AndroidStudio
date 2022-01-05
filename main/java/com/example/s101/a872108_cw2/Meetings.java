package com.example.s101.a872108_cw2;

public class Meetings {


    private String time;

    public Meetings(){

    }
public Meetings (String meetingTime) {

    this.time = meetingTime;

}

    public String get_meetingTime() {
        return time;
    }

    public void set_meetingTime(String time) {
        this.time = time;
    }

}

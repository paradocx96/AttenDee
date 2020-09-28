package com.androx.attendee;

public class Attendance {

    private int id;
    private String name;
    private String dateTime;
    private String remarks;

    public Attendance(int id, String name, String dateTime, String remarks) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.remarks = remarks;
    }

    public Attendance(String name, String dateTime, String remarks) {
        this.name = name;
        this.dateTime = dateTime;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

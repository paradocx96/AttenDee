package com.androx.attendee;

public class Event {

    private int id;
    private String name;
    private String date;
    private String remarks;

    public Event() {
    }

    public Event(int id, String name, String date, String remarks) {
        this.id = id;
        this.name = name;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

package edu.serviceSender.Model;

public class User {
    private final int id;
    private final String date;
    private final String text;
    private final String time;

    public User(int id, String date, String text, String time) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }
}

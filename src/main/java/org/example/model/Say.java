package org.example.model;

public class Say {
    private int id = -1;
    private String writer = "미등록";
    private String text = "미등록";

    public Say() {
    }

    public Say(int id, String writer, String text) {
        this.id = id;
        this.writer = writer;
        this.text = text;
    }


    public int getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getText() {
        return text;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setText(String text) {
        this.text = text;
    }
}

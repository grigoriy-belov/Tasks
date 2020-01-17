package com.greg.privatelink.note;

public class NoteRequest {

    private String text;

    public NoteRequest() {
    }

    public NoteRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

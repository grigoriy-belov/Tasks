package com.greg.privatelink.note;

import java.util.UUID;

public class NoteResponse {

    private UUID id;

    private String text;


    public NoteResponse() {
    }

    public NoteResponse(UUID id, String text) {
        this.id = id;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

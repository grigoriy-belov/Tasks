package com.alevel.socialnetwork.model;


import java.util.ArrayList;
import java.util.List;

public class Comment {

    private long id;

    private String text;

    private Persisted<Long, User> author;

    private Persisted<Long, Photo> photo;

    private List<CommentLike> commentLikes = new ArrayList<>();

    public Comment() {
    }

    public Comment(String text) {
        this.text = text;
    }
}

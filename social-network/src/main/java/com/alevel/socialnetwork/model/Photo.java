package com.alevel.socialnetwork.model;

import java.util.ArrayList;
import java.util.List;

public class Photo {

    private long id;

    private String name;

    private Persisted<Long, User> author;

    private List<Comment> comments = new ArrayList<>();

    private List<Photo> photoLikes = new ArrayList<>();

    public Photo() {
    }

    public Photo(String name, Persisted<Long, User> author) {
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Persisted<Long, User> getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Photo> getPhotoLikes() {
        return photoLikes;
    }
}

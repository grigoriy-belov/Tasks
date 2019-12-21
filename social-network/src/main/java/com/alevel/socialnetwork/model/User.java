package com.alevel.socialnetwork.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private long id;

    private String name;

    private List<Photo> photos = new ArrayList<>();

    private List<Comment> comments = new ArrayList<>();

    private List<UserLike> userLikes = new ArrayList<>();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<UserLike> getUserLikes() {
        return userLikes;
    }
}

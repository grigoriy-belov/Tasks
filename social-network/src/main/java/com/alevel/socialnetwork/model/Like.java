package com.alevel.socialnetwork.model;

public class Like {

    private final Persisted<Long, User> author;

    public Like(Persisted<Long, User> author) {
        this.author = author;
    }
}

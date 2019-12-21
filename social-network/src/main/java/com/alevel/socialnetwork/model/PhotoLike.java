package com.alevel.socialnetwork.model;

public class PhotoLike extends Like {

    private final Persisted<Long, Photo> target;

    public PhotoLike(Persisted<Long, User> author, Persisted<Long, Photo> target) {
        super(author);
        this.target = target;
    }

    public Persisted<Long, Photo> getTarget() {
        return target;
    }
}

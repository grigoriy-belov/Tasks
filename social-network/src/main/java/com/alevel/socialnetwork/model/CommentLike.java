package com.alevel.socialnetwork.model;

public class CommentLike extends Like {

    private final Persisted<Long, Comment> target;

    public CommentLike(Persisted<Long, User> author, Persisted<Long, Comment> target) {
        super(author);
        this.target = target;
    }

    public Persisted<Long, Comment> getTarget() {
        return target;
    }
}

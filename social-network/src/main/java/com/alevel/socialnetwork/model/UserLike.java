package com.alevel.socialnetwork.model;

public class UserLike extends Like {

    private final Persisted<Long, User> target;

    public UserLike(Persisted<Long, User> author, Persisted<Long, User> recipient) {
        super(author);
        this.target = recipient;
    }

    public Persisted<Long, User> getTarget() {
        return target;
    }
}

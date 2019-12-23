package com.alevel.socialnetwork.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_likes")
public class UserLike {

    @EmbeddedId
    private UserLikeId id;

    public UserLike() {
    }

    public UserLike(UserLikeId id) {
        this.id = id;
    }

    public UserLikeId getId() {
        return id;
    }

    public void setId(UserLikeId id) {
        this.id = id;
    }
}

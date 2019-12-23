package com.alevel.socialnetwork.entity;

import javax.persistence.*;

@Entity
@Table(name = "photo_likes")
public class PhotoLike {

    @EmbeddedId
    private PhotoLikeId id;

    public PhotoLike() {
    }

    public PhotoLike(PhotoLikeId id) {
        this.id = id;
    }

    public PhotoLikeId getId() {
        return id;
    }

    public void setId(PhotoLikeId id) {
        this.id = id;
    }
}

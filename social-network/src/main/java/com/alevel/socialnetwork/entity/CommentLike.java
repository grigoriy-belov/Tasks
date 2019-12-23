package com.alevel.socialnetwork.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment_likes")
public class CommentLike  {

    @EmbeddedId
    private CommentLikeId id;

    public CommentLike() {
    }

    public CommentLike(CommentLikeId id) {
        this.id = id;
    }

    public CommentLikeId getId() {
        return id;
    }

    public void setId(CommentLikeId id) {
        this.id = id;
    }
}

package com.alevel.socialnetwork.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_likes")
public class UserLike {

    @EmbeddedId
    private UserLikeId id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @MapsId("authorId")
    private User author;

    @ManyToOne
    @JoinColumn(name = "target_user_id")
    @MapsId("targetUserId")
    private User targetUser;

    public UserLike() {
    }

    public UserLike(User author, User targetUser) {
        this.targetUser = targetUser;
    }

    public User getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public UserLikeId getId() {
        return id;
    }

    public void setId(UserLikeId id) {
        this.id = id;
    }
}

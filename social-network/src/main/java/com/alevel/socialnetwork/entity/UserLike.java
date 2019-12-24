package com.alevel.socialnetwork.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_likes")
public class UserLike extends LikeEntity {

    @ManyToOne
    @JoinColumn(name = "target_user_id")
    private User targetUser;

    public UserLike() {
    }

    public UserLike(User author, User targetUser) {
        super(author);
        this.targetUser = targetUser;
    }

    public User getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }
}

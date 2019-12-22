package com.alevel.socialnetwork.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_likes")
public class UserLike extends Like {

    @OneToOne
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

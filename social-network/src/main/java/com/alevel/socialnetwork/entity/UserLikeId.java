package com.alevel.socialnetwork.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserLikeId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "target_user_id")
    private User targetUser;

    public UserLikeId() {
    }

    public UserLikeId(User author, User targetUser) {
        this.author = author;
        this.targetUser = targetUser;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLikeId that = (UserLikeId) o;
        return Objects.equals(author, that.author) &&
                Objects.equals(targetUser, that.targetUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, targetUser);
    }
}

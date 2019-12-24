package com.alevel.socialnetwork.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_likes")
public class UserLike implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Id
    @ManyToOne
    @JoinColumn(name = "target_user_id")
    private User targetUser;

    public UserLike() {
    }

    public UserLike(User author, User targetUser) {
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
        UserLike userLike = (UserLike) o;
        return Objects.equals(author, userLike.author) &&
                Objects.equals(targetUser, userLike.targetUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, targetUser);
    }
}

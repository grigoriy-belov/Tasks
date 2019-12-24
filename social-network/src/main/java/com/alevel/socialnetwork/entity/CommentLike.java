package com.alevel.socialnetwork.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "comment_likes")
public class CommentLike implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Id
    @ManyToOne
    @JoinColumn(name = "target_comment_id")
    private Comment targetComment;

    public CommentLike() {
    }

    public CommentLike(User author, Comment targetComment) {
        this.author = author;
        this.targetComment = targetComment;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Comment getTargetComment() {
        return targetComment;
    }

    public void setTargetComment(Comment targetComment) {
        this.targetComment = targetComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentLike that = (CommentLike) o;
        return author.equals(that.author) &&
                targetComment.equals(that.targetComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, targetComment);
    }
}

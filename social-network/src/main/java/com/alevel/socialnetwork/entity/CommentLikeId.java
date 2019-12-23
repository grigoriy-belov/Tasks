package com.alevel.socialnetwork.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CommentLikeId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "target_comment_id")
    private Comment targetComment;


    public CommentLikeId() {
    }

    public CommentLikeId(User author, Comment targetComment) {
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
        CommentLikeId that = (CommentLikeId) o;
        return Objects.equals(author, that.author) &&
                Objects.equals(targetComment, that.targetComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, targetComment);
    }
}

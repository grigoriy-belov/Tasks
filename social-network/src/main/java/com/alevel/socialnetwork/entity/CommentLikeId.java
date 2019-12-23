package com.alevel.socialnetwork.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CommentLikeId implements Serializable {

    private long authorId;

    private long targetCommentId;

    public CommentLikeId() {
    }

    public CommentLikeId(long authorId, long targetCommentId) {
        this.authorId = authorId;
        this.targetCommentId = targetCommentId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getTargetCommentId() {
        return targetCommentId;
    }

    public void setTargetCommentId(long targetCommentId) {
        this.targetCommentId = targetCommentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentLikeId that = (CommentLikeId) o;
        return authorId == that.authorId &&
                targetCommentId == that.targetCommentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, targetCommentId);
    }
}

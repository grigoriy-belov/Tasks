package com.alevel.socialnetwork.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserLikeId implements Serializable {

    private long authorId;

    private long targetUserId;

    public UserLikeId() {
    }

    public UserLikeId(long authorId, long targetUserId) {
        this.authorId = authorId;
        this.targetUserId = targetUserId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(long targetUserId) {
        this.targetUserId = targetUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLikeId that = (UserLikeId) o;
        return authorId == that.authorId &&
                targetUserId == that.targetUserId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, targetUserId);
    }
}

package com.alevel.socialnetwork.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PhotoLikeId implements Serializable {

    private Long authorId;
    private Long targetPhotoId;

    public PhotoLikeId() {
    }

    public PhotoLikeId(Long authorId, Long targetPhotoId) {
        this.authorId = authorId;
        this.targetPhotoId = targetPhotoId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getTargetPhotoId() {
        return targetPhotoId;
    }

    public void setTargetPhotoId(Long targetPhotoId) {
        this.targetPhotoId = targetPhotoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoLikeId that = (PhotoLikeId) o;
        return Objects.equals(authorId, that.authorId) &&
                Objects.equals(targetPhotoId, that.targetPhotoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, targetPhotoId);
    }
}

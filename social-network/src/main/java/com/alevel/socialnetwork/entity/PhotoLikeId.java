package com.alevel.socialnetwork.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PhotoLikeId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "target_photo_id")
    private Photo targetPhoto;

    public PhotoLikeId() {
    }

    public PhotoLikeId(User author, Photo targetPhoto) {
        this.author = author;
        this.targetPhoto = targetPhoto;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Photo getTargetPhoto() {
        return targetPhoto;
    }

    public void setTargetPhoto(Photo targetPhoto) {
        this.targetPhoto = targetPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoLikeId that = (PhotoLikeId) o;
        return Objects.equals(author, that.author) &&
                Objects.equals(targetPhoto, that.targetPhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, targetPhoto);
    }
}


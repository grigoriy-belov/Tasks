package com.alevel.socialnetwork.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "photo_likes")
public class PhotoLike implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Id
    @ManyToOne
    @JoinColumn(name = "target_photo_id")
    private Photo targetPhoto;

    public PhotoLike() {
    }

    public PhotoLike(User author, Photo targetPhoto) {
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
        PhotoLike photoLike = (PhotoLike) o;
        return Objects.equals(author, photoLike.author) &&
                Objects.equals(targetPhoto, photoLike.targetPhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, targetPhoto);
    }
}

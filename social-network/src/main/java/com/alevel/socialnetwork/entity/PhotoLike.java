package com.alevel.socialnetwork.entity;

import javax.persistence.*;

@Entity
@Table(name = "photo_likes")
public class PhotoLike {

    @EmbeddedId
    private PhotoLikeId id;

    @OneToOne
    @JoinColumn(name = "author_id")
    @MapsId("authorId")
    private User author;

    @ManyToOne
    @JoinColumn(name = "target_photo_id")
    @MapsId("targetPhotoId")
    private Photo targetPhoto;

    public PhotoLike() {
    }

    public PhotoLike(User author, Photo targetPhoto) {
        this.targetPhoto = targetPhoto;
    }

    public Photo getTargetPhoto() {
        return targetPhoto;
    }

    public void setTargetPhoto(Photo targetPhoto) {
        this.targetPhoto = targetPhoto;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public PhotoLikeId getId() {
        return id;
    }

    public void setId(PhotoLikeId id) {
        this.id = id;
    }
}

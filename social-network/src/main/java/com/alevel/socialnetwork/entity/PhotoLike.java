package com.alevel.socialnetwork.entity;

import javax.persistence.*;

@Entity
@Table(name = "photo_likes",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "target_photo_id"})
        })
public class PhotoLike extends LikeEntity {

    @ManyToOne
    @JoinColumn(name = "target_photo_id")
    private Photo targetPhoto;

    public PhotoLike() {
    }

    public PhotoLike(User author, Photo targetPhoto) {
        super(author);
        this.targetPhoto = targetPhoto;
    }

    public Photo getTargetPhoto() {
        return targetPhoto;
    }

    public void setTargetPhoto(Photo targetPhoto) {
        this.targetPhoto = targetPhoto;
    }

}

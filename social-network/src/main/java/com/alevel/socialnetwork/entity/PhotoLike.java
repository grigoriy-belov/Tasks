package com.alevel.socialnetwork.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "photo_likes")
public class PhotoLike extends _Like {

    @OneToOne
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

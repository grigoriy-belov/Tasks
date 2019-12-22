package com.alevel.socialnetwork.entity;

import javax.persistence.*;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLike> userLikes = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoLike> photoLikes = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentLike> commentLikes = new ArrayList<>();


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<UserLike> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<UserLike> userLikes) {
        this.userLikes = userLikes;
    }

    public List<PhotoLike> getPhotoLikes() {
        return photoLikes;
    }

    public void setPhotoLikes(List<PhotoLike> photoLikes) {
        this.photoLikes = photoLikes;
    }

    public List<CommentLike> getCommentLikes() {
        return commentLikes;
    }

    public void setCommentLikes(List<CommentLike> commentLikes) {
        this.commentLikes = commentLikes;
    }

    public void addUserLike(UserLike like) {
        userLikes.add(like);
        like.setAuthor(this);
    }

    public void removeUserLike(UserLike like) {
        userLikes.remove(like);
        like.setAuthor(null);
    }

    public void addCommentLike(CommentLike like) {
        commentLikes.add(like);
        like.setAuthor(this);
    }

    public void removeCommentLike(CommentLike like) {
        commentLikes.remove(like);
        like.setAuthor(null);
    }

     public void addPhotoLike(PhotoLike like) {
        photoLikes.add(like);
        like.setAuthor(this);
    }

    public void removePhotoLike(PhotoLike like) {
        photoLikes.remove(like);
        like.setAuthor(null);
    }

}

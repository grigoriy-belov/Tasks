package com.alevel.socialnetwork.entity;

import javax.persistence.*;
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
    private List<_Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "targetUser",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLike> userLikes = new ArrayList<>();

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

    public List<_Like> getLikes() {
        return likes;
    }

    public void setLikes(List<_Like> likes) {
        this.likes = likes;
    }

    public List<UserLike> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<UserLike> userLikes) {
        this.userLikes = userLikes;
    }

    public void addLike(_Like like) {
        likes.add(like);
        like.setAuthor(this);
    }

    public void removeLike(_Like like) {
        likes.remove(like);
        like.setAuthor(null);
    }

    public void addUserLike(UserLike like) {
        userLikes.add(like);
        like.setTargetUser(this);
    }

    public void removeUserLike(UserLike like) {
        userLikes.remove(like);
        like.setTargetUser(null);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setAuthor(this);
    }

    public void removeLike(Comment comment) {
        comments.remove(comment);
        comment.setAuthor(null);
    }

    public void addPhoto(Photo photo) {
        photos.add(photo);
        photo.setAuthor(this);
    }

    public void removePhoto(Photo photo) {
        photos.remove(photo);
        photo.setAuthor(null);
    }
}

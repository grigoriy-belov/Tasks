package com.alevel.socialnetwork.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    FetchType.LAZY parameter for @OneToMany associations can be used for performance optimization
*/

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<PhotoLike> likes = new ArrayList<>();

    public Photo() {
    }

    public Photo(String name, User author) {
        this.name = name;
        this.author = author;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

//    public List<PhotoLike> getLikes() {
//        return likes;
//    }

//    public void setLikes(List<PhotoLike> likes) {
//        this.likes = likes;
//    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPhoto(this);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setPhoto(null);
    }

//    public void addLike(PhotoLike like) {
//        likes.add(like);
//        like.setTargetPhoto(this);
//    }
//
//    public void removeLike(PhotoLike like) {
//        likes.remove(like);
//        like.setTargetPhoto(null);
//    }
}

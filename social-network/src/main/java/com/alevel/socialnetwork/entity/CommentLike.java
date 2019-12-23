package com.alevel.socialnetwork.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment_likes")
public class CommentLike  {

    @EmbeddedId
    private CommentLikeId id;

    @OneToOne
    @JoinColumn(name = "author_id")
    @MapsId("authorId")
    private User author;

    @ManyToOne
    @JoinColumn(name = "target_comment_id")
    @MapsId("targetCommentId")
    private Comment targetComment;

    public CommentLike() {
    }

    public CommentLike(User author, Comment targetComment) {
        this.targetComment = targetComment;
    }

    public Comment getTargetComment() {
        return targetComment;
    }

    public void setTargetComment(Comment targetComment) {
        this.targetComment = targetComment;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


}

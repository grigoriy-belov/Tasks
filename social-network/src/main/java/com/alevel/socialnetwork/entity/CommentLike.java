package com.alevel.socialnetwork.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment_likes")
public class CommentLike  {

    @OneToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "target_comment_id")
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
}

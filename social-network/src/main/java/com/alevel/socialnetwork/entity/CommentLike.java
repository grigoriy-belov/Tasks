package com.alevel.socialnetwork.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment_likes")
public class CommentLike extends Like {

    @OneToOne
    @JoinColumn(name = "target_comment_id")
    private Comment targetComment;

    public CommentLike() {
    }

    public CommentLike(User author, Comment targetComment) {
        super(author);
        this.targetComment = targetComment;
    }

    public Comment getTargetComment() {
        return targetComment;
    }

    public void setTargetComment(Comment targetComment) {
        this.targetComment = targetComment;
    }
}

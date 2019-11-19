package com.alevel.textboard.model;

import java.util.ArrayList;
import java.util.List;

public class Comment {

    private final User author;
    private final Thread thread;
    private final Comment parentComment;
    private final List<Comment> replies;

    public Comment(User author, Thread thread, Comment parentComment) {
        this.author = author;
        this.thread = thread;
        thread.getReplies().add(this);
        this.parentComment = parentComment;
        this.replies = new ArrayList<>();
        parentComment.replies.add(this);
    }

    public User getAuthor() {
        return author;
    }

    public Thread getThread() {
        return thread;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public List<Comment> getReplies() {
        return replies;
    }
}

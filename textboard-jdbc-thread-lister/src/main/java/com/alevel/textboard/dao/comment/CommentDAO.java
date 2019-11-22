package com.alevel.textboard.dao.comment;

import com.alevel.textboard.dao.DAO;
import com.alevel.textboard.model.Comment;
import com.alevel.textboard.model.Persisted;

import java.util.List;

public interface CommentDAO extends DAO<Long, Comment> {
    List<Persisted<Long, Comment>> findByThreadId(Long authorId);
}

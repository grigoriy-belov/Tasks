package dao.comment;

import dao.DAO;
import model.Comment;

import java.util.List;

public interface CommentDAO extends DAO<Long, Comment> {
    List<Comment> findByAuthorId(Long authorId);
}

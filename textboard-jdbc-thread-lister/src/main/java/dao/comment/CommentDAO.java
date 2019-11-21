package dao.comment;

import dao.DAO;
import model.Comment;
import model.Persisted;

import java.util.List;

public interface CommentDAO extends DAO<Long, Comment> {
    List<Persisted<Long, Comment>> findByThreadId(Long authorId);
}

package dao.comment;

import dao.DataAccessException;
import model.Comment;
import model.Persisted;
import model.Thread;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCCommentDAO implements CommentDAO {
    private final Connection connection;

    public JDBCCommentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Persisted<Long, Comment>> findByThreadId(Long threadId) {
        String sql = "SELECT c.id, parent_comment_id, email, nickname, title, c.text, t.text, author_id, thread_id " +
                    "FROM comments AS c " +
                    "JOIN users AS u ON c.author_id = u.id " +
                    "JOIN threads AS t ON c.thread_id = t.id " +
                    "WHERE thread_id = ? AND parent_comment_id IS NULL " +
                     "ORDER BY c.id ;";

        return findOne(threadId, sql);
    }

    public List<Persisted<Long, Comment>> findByParentId(long id) {
        String sql = "SELECT c.id, parent_comment_id, email, nickname, title, c.text, t.text, author_id, thread_id " +
                "FROM comments AS c " +
                "JOIN users AS u ON c.author_id = u.id " +
                "JOIN threads AS t ON c.thread_id = t.id " +
                "WHERE parent_comment_id = ? " +
                "ORDER BY c.id;";
        return findOne(id, sql);
    }

    private List<Persisted<Long, Comment>> findOne(Long threadId, String sql) {
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, threadId);
            ResultSet resultSet = ps.executeQuery();
            List<Persisted<Long, Comment>> results = new ArrayList<>();
            while (resultSet.next()) {
               results.add(mapRowToComment(resultSet));
            }
            return results;
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    private Persisted<Long, Comment> mapRowToComment(ResultSet resultSet) throws SQLException {

        User user = new User(
                resultSet.getString("email"),
                resultSet.getString("nickname")
        );

        Thread thread = new Thread(
                user,
                resultSet.getString("title"),
                resultSet.getString("t.text")
        );

        Long id = resultSet.getLong("id");

        long parentId = resultSet.getLong("parent_comment_id");

        List<Persisted<Long, Comment>> persistedReplyComments = findByParentId(id);
        List<Comment> replyComments = new ArrayList<>();
        for (Persisted<Long, Comment> p : persistedReplyComments) {
            replyComments.add(p.getValue());
        }

        Comment comment = new Comment(
                new Persisted<>(
                        resultSet.getLong("author_id"),
                        user
                ),
                new Persisted<>(
                        resultSet.getLong("thread_id"),
                        thread
                ),
                null,
                resultSet.getString("c.text"),
                replyComments
        );

        return new Persisted<>(
                id,
                comment
        );
    }
}

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
        String sql = "SELECT c.id, parent_comment_id, email, nickname, title, c.text, author_id, thread_id " +
                    "FROM comments AS c " +
                    "JOIN users AS u ON c.author_id = u.id " +
                    "JOIN threads AS t ON c.thread_id = t.id " +
                    "WHERE thread_id = ?;";
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
                resultSet.getString("text")
        );

        Long id = resultSet.getLong("id");

        long parentId = resultSet.getLong("parent_comment_id");

        Persisted<Long, Comment> parent = parentId == 0 ? null : new Persisted<>(parentId, null);

        Comment comment = new Comment(
                new Persisted<>(
                        resultSet.getLong("author_id"),
                        user
                ),
                new Persisted<>(
                        resultSet.getLong("thread_id"),
                        thread
                ),
                parent,
                resultSet.getString("c.text")
        );

        return new Persisted<>(
                id,
                comment
        );
    }
}

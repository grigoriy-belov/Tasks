package dao.comment;

import dao.DataAccessException;
import model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCCommentDAO implements CommentDAO {
    private final Connection connection;

    public JDBCCommentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Comment> findByAuthorId(Long authorId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, authorId);
            ResultSet resultSet = ps.executeQuery();
            List<Comment> results = new ArrayList<>();
            while (resultSet.next()) {
                results.add(mapRowToComment(resultSet));
            }
            return results;
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    private Comment mapRowToComment(ResultSet resultSet) {

    }
}

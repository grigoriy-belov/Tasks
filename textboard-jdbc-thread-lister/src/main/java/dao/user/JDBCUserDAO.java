package dao.user;

import dao.DataAccessException;
import model.Persisted;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JDBCUserDAO implements UserDAO {
    private Connection connection;

    public JDBCUserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Persisted<Long, User>> findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?;";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            return findOne(ps);
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    private Optional<Persisted<Long, User>> findOne(PreparedStatement ps) throws SQLException {
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.first()) {
            return Optional.of(mapRowToUser(resultSet));
        } else {
            return Optional.empty();
        }
    }

    private Persisted<Long, User> mapRowToUser(ResultSet resultSet) throws SQLException {
        User user = new User(
                resultSet.getString("email"),
                resultSet.getString("nickname")
        );
        return new Persisted<>(
                resultSet.getLong("id"),
                user
        );
    }
}

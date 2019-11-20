package dao.thread;

import dao.DataAccessException;
import model.Persisted;
import model.User;
import model.Thread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCThreadDAO implements ThreadDAO {
    private final Connection connection;

    public JDBCThreadDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Persisted<Long, Thread>> findByName(String name) {
        String sqlThreads = "SELECT t.id, title, text, email, nickname FROM threads AS t " +
                            "JOIN users AS u ON op_id = u.id " +
                            "WHERE title LIKE '%" + name +"%';";
        try(PreparedStatement ps = connection.prepareStatement(sqlThreads)) {
            ResultSet resultSet = ps.executeQuery();
            List<Persisted<Long, Thread>> results = new ArrayList<>();
            while (resultSet.next()) {
                results.add(mapRowToUser(resultSet));
            }
            return results;
        } catch (SQLException e) {
            throw new DataAccessException(e);
        }
    }

    private static Persisted<Long, Thread> mapRowToUser (ResultSet resultSet) throws SQLException {

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

        return new Persisted<>(id, thread);
    }
}

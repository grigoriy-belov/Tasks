package com.alevel.textboard.dao.user;

import com.alevel.textboard.model.Persisted;
import com.alevel.textboard.model.User;

import java.lang.management.OperatingSystemMXBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public final class JDBCUserDAO implements UserDAO {

    private final Connection connection;

    public JDBCUserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Persisted<Long, User>> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.first()) {
                User user = new User(
                        resultSet.getString("email"),
                        resultSet.getString("nickname")
                );
                return Optional.of(new Persisted<>(
                        resultSet.getLong("id"),
                        user
                ));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Persisted<Long, User>> findByNickname(String nickName) {
        return Optional.empty();
    }

    @Override
    public List<Persisted<Long, User>> findAll() {
        return null;
    }

    @Override
    public Optional<Persisted<Long, User>> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void update(Long aLong, User entity) {

    }

    @Override
    public void delete(Long aLong) {

    }
}

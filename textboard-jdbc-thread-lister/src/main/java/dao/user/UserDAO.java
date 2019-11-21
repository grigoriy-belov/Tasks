package dao.user;

import dao.DAO;
import model.Persisted;
import model.User;

import java.util.Optional;

public interface UserDAO extends DAO<Long, User> {

    Optional<Persisted<Long, User>> findById(Long id);
}

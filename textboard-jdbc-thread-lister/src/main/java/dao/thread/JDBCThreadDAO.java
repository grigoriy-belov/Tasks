package dao.thread;

import model.Persisted;

import java.util.List;

public class JDBCThreadDAO implements ThreadDAO {
    @Override
    public List<Persisted<Long, Thread>> findByName(String name) {
        return null;
    }
}

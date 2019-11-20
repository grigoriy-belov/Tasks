package dao.thread;

import dao.DAO;
import model.Persisted;
import model.Thread;

import java.util.List;

public interface ThreadDAO extends DAO<Long, Thread> {
    List<Persisted<Long, Thread>> findByName(String name);
}

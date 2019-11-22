package com.alevel.textboard.dao.thread;

import com.alevel.textboard.dao.DAO;
import com.alevel.textboard.model.Persisted;
import com.alevel.textboard.model.Thread;

import java.util.List;

public interface ThreadDAO extends DAO<Long, Thread> {
    List<Persisted<Long, Thread>> findByName(String name);
}

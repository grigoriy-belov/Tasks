package dao;

import model.Persisted;

import java.util.List;

public interface DAO<ID, T> {
    List<Persisted<ID, T>> findByName(String name);
}

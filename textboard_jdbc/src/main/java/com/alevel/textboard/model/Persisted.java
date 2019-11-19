package com.alevel.textboard.model;

import java.util.Objects;

public class Persisted<ID, T> {

    private final ID id;

    private final T value;

    public Persisted(ID id, T value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persisted<?, ?> persisted = (Persisted<?, ?>) o;
        return Objects.equals(persisted.id, id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

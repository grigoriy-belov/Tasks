package com.greg.privatelink.note;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryNoteService implements NoteService {

    private final Map<UUID, String> store = new ConcurrentHashMap<>();

    @Override
    public UUID add(String note) {
        UUID id = UUID.randomUUID();
        store.put(id, note);
        return id;
    }

    @Override
    public Optional<String> findAndRemove(UUID id) {
        return Optional.ofNullable(store.remove(id));
    }
}

package com.greg.privatelink.note;

import java.util.Optional;
import java.util.UUID;

public interface NoteService {

    UUID add(String note);

    Optional<String> findAndRemove(UUID id);

}

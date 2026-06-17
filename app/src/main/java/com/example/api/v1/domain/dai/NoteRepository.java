package com.example.api.v1.domain.dai;

import com.example.api.v1.domain.entity.Note;
import java.util.List;
import java.util.Optional;

public interface NoteRepository {
  public void save(Note note);

  public void saveAll(List<Note> notes);

  public void update(Note note);

  public void delete(Note note);

  public Optional<Note> findOne(Note note);

  public List<Note> search(Note note);
}

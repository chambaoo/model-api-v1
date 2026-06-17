package com.example.api.v1.infrastructure.memory.note;

import com.example.api.v1.domain.dai.NoteRepository;
import com.example.api.v1.domain.entity.Note;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class NoteMemoryRepository implements NoteRepository {

  private ArrayList<Note> notes = new ArrayList<>();

  @Override
  public void save(Note note) {
    this.notes.add(note);
    System.out.println("added🐟Length：" + this.notes.size());
  }

  @Override
  public void saveAll(List<Note> notes) {
    this.notes.addAll(notes);
  }

  @Override
  public void update(Note note) {
    this.notes.stream()
        .filter(n -> n.getId().equals(note.getId()))
        .findFirst()
        .ifPresent(
            n -> {
              n.setContent(note.getContent());
            });
  }

  @Override
  public void delete(Note note) {
    this.notes.remove(note);
  }

  @Override
  public Optional<Note> findOne(Note note) {

    System.out.println("findOne🐟Length：" + this.notes.size());

    return this.notes.stream().findFirst();
    // return this.notes.stream().filter(n -> n.getId().equals(note.getId())).findFirst();
  }

  @Override
  public List<Note> search(Note note) {
    return this.notes;
  }
}

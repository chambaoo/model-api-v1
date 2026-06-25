package com.example.api.v1.application.note;

import com.example.api.v1.domain.dai.NoteRepository;
import com.example.api.v1.domain.entity.Note;
import com.example.api.v1.domain.object.NoteId;
import org.springframework.stereotype.Service;

@Service
public class FindOneNoteInteractor implements FindOneNoteUseCase {
  private final NoteRepository repository;

  public FindOneNoteInteractor(NoteRepository repository) {
    this.repository = repository;
  }

  public FindOneNoteOutput handle(FindOneNoteInput input) {
    NoteId noteId = input.getId();
    var note = new Note();
    note.setId(noteId);
    var foundNote = repository.findOne(note);
    if (foundNote.isEmpty()) {
      return null;
    }
    var n = foundNote.get();
    return new FindOneNoteOutput(
        n.getId(), n.getContent(), n.getTags(), n.getCreatedAt(), n.getUpdatedAt());
  }
}

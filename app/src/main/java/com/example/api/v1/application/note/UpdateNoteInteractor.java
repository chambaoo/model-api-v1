package com.example.api.v1.application.note;

import com.example.api.v1.domain.dai.NoteRepository;
import com.example.api.v1.domain.entity.Note;
import com.example.api.v1.domain.object.NoteContent;
import com.example.api.v1.domain.object.NoteId;
import org.springframework.stereotype.Service;

@Service
public class UpdateNoteInteractor implements UpdateNoteUseCase {
  private final NoteRepository repository;

  public UpdateNoteInteractor(NoteRepository repository) {
    this.repository = repository;
  }

  public UpdateNoteOutput handle(UpdateNoteInput input) {
    NoteId noteId = new NoteId(input.getId().getValue());
    var note = new Note();
    note.setId(noteId);

    var exsist = repository.findOne(note).isPresent();
    if (!exsist) {
      throw new RuntimeException("Not found note id = " + input.getId().getValue());
    }

    if (input.getContent().getValue().isEmpty()) {
      throw new RuntimeException("Note content is required.");
    }

    note.setContent(new NoteContent(input.getContent().getValue()));

    repository.update(note);
    return new UpdateNoteOutput(noteId);
  }
}

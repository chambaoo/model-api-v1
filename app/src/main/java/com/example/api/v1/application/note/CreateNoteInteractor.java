package com.example.api.v1.application.note;

import com.example.api.v1.domain.dai.NoteRepository;
import com.example.api.v1.domain.entity.Note;
import com.example.api.v1.domain.object.NoteId;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Service;

@Service
public class CreateNoteInteractor implements CreateNoteUseCase {

  private final NoteRepository repository;

  public CreateNoteInteractor(NoteRepository repository) {
    this.repository = repository;
  }

  public CreateNoteOutput handle(CreateNoteInput input) {
    NoteId noteId = NoteId.generateNoteId();
    var note =
        new Note(
            noteId, input.getContent(), input.getTags(), ZonedDateTime.now(), ZonedDateTime.now());
    repository.save(note);
    return new CreateNoteOutput(noteId);
  }
}

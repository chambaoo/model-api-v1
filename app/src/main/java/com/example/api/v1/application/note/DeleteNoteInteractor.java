package com.example.api.v1.application.note;

import com.example.api.v1.domain.dai.NoteRepository;
import com.example.api.v1.domain.entity.Note;
import org.springframework.stereotype.Service;

@Service
public class DeleteNoteInteractor implements DeleteNoteUseCase {

  private final NoteRepository repository;

  public DeleteNoteInteractor(NoteRepository repository) {
    this.repository = repository;
  }

  public DeleteNoteOutput handle(DeleteNoteInput input) {
    var note = new Note();
    note.setId(input.getId());

    var exsist = repository.findOne(note).isPresent();
    if (!exsist) {
      throw new RuntimeException("Not found note id = " + input.getId().getValue());
    }

    repository.delete(note);
    return new DeleteNoteOutput(input.getId());
  }
}

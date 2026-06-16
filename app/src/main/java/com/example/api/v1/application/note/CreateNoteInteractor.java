package com.example.api.v1.application.note;

import com.example.api.v1.domain.object.NoteId;

public class CreateNoteInteractor {
  public CreateNoteOutput handle(CreateNoteInput input) {
    NoteId noteId = NoteId.generateNoteId();
    return new CreateNoteOutput(noteId);
  }
}

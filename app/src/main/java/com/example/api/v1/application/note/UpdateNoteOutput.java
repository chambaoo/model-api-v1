package com.example.api.v1.application.note;

import com.example.api.v1.application.base.Output;
import com.example.api.v1.domain.object.NoteId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateNoteOutput implements Output {
  private NoteId id;
}

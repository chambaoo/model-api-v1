package com.example.api.v1.application.note;

import com.example.api.v1.application.base.Output;
import com.example.api.v1.domain.object.NoteContent;
import com.example.api.v1.domain.object.NoteId;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindOneNoteOutput implements Output {
  private NoteId id;
  private NoteContent content;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
}

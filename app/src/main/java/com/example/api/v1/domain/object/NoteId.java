package com.example.api.v1.domain.object;

import com.github.f4b6a3.ulid.UlidCreator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoteId {
  private String value;

  public static NoteId generateNoteId() {
    return new NoteId(UlidCreator.getUlid().toLowerCase());
  }
}

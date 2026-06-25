package com.example.api.v1.application.note;

import com.example.api.v1.application.base.Input;
import com.example.api.v1.domain.object.NoteId;
import com.example.api.v1.domain.object.Tag;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SearchNoteInput implements Input {
  private Optional<List<NoteId>> ids;
  private Optional<List<Tag>> tags;
}

package com.example.api.v1.application.note;

import com.example.api.v1.application.base.Output;
import com.example.api.v1.domain.entity.Note;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchNoteOutput implements Output {
  private Optional<List<Note>> items;
  private int total;
}

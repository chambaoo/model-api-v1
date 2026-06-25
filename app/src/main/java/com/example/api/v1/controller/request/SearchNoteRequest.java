package com.example.api.v1.controller.request;

import com.example.api.v1.domain.object.NoteId;
import com.example.api.v1.domain.object.Tag;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class SearchNoteRequest {
  private List<String> ids;
  private List<String> tags;

  public Optional<List<NoteId>> getNoteIds() {
    if (ids == null) {
      return Optional.empty();
    }
    return Optional.of(ids.stream().map(NoteId::new).collect(Collectors.toList()));
  }

  public Optional<List<Tag>> getTags() {
    if (tags == null) {
      return Optional.empty();
    }
    return Optional.of(tags.stream().map(Tag::new).collect(Collectors.toList()));
  }
}

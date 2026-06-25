package com.example.api.v1.controller.request;

import com.example.api.v1.domain.object.Tag;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class CreateNoteRequest {
  private String content;
  private List<String> tags;

  public Optional<List<Tag>> getTags() {
    if (tags == null) {
      return Optional.empty();
    }
    return Optional.of(tags.stream().map(Tag::new).collect(Collectors.toList()));
  }
}

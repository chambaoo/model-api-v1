package com.example.api.v1.domain.entity;

import com.example.api.v1.domain.object.NoteContent;
import com.example.api.v1.domain.object.NoteId;
import com.example.api.v1.domain.object.Tag;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Note {
  private NoteId id;
  private NoteContent content;
  private Optional<List<Tag>> tags;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
}

package com.example.api.v1.controller.response;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FindOneNoteResponse {
  private String id;
  private String content;
  private Optional<List<String>> tags;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
}

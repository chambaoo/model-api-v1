package com.example.api.v1.controller.response;

import com.example.api.v1.domain.entity.Note;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchNoteResponse {
  private List<Note> items = new ArrayList<>();
  private int total = 0;
}

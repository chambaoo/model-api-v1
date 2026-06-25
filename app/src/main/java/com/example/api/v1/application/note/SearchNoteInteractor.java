package com.example.api.v1.application.note;

import com.example.api.v1.domain.dai.NoteRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SearchNoteInteractor implements SearchNoteUseCase {
  private final NoteRepository repository;

  public SearchNoteInteractor(NoteRepository repository) {
    this.repository = repository;
  }

  public SearchNoteOutput handle(SearchNoteInput input) {
    return new SearchNoteOutput(Optional.empty(), 0);
  }
}

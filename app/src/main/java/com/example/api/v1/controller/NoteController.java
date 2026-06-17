package com.example.api.v1.controller;

import com.example.api.v1.application.note.CreateNoteInput;
import com.example.api.v1.application.note.CreateNoteInteractor;
import com.example.api.v1.application.note.FindOneNoteInput;
import com.example.api.v1.application.note.FindOneNoteInteractor;
import com.example.api.v1.controller.request.CreateNoteRequest;
import com.example.api.v1.controller.response.CreateNoteResponse;
import com.example.api.v1.controller.response.FindOneNoteResponse;
import com.example.api.v1.domain.object.NoteContent;
import com.example.api.v1.domain.object.NoteId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

  private final CreateNoteInteractor createNoteInteractor;
  private final FindOneNoteInteractor findOneNoteInteractor;

  public NoteController(
      CreateNoteInteractor createNoteInteractor, FindOneNoteInteractor findOneNoteInteractor) {
    this.createNoteInteractor = createNoteInteractor;
    this.findOneNoteInteractor = findOneNoteInteractor;
  }

  @PostMapping("/notes")
  public CreateNoteResponse create(@RequestBody CreateNoteRequest note) {
    var input = new CreateNoteInput(new NoteContent(note.getContent()));
    var output = createNoteInteractor.handle(input);
    var response = new CreateNoteResponse(output.getId().getValue());

    return response;
  }

  @GetMapping("/notes/{id}")
  public FindOneNoteResponse findOne(@PathVariable String id) {
    var input = new FindOneNoteInput(new NoteId(id));
    var output = findOneNoteInteractor.handle(input);
    if (output == null) {
      return null;
    }
    return new FindOneNoteResponse(
        output.getId().getValue(),
        output.getContent().getValue(),
        output.getCreatedAt(),
        output.getUpdatedAt());
  }

  @GetMapping("/notes")
  public String search() {
    return "List of notes";
  }
}

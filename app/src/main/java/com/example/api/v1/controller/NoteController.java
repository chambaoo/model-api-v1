package com.example.api.v1.controller;

import com.example.api.v1.application.note.CreateNoteInput;
import com.example.api.v1.application.note.CreateNoteInteractor;
import com.example.api.v1.controller.request.CreateNoteRequest;
import com.example.api.v1.controller.response.CreateNoteResponse;
import com.example.api.v1.domain.object.NoteContent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

  @PostMapping("/notes")
  public CreateNoteResponse create(@RequestBody CreateNoteRequest note) {
    var input = new CreateNoteInput(new NoteContent(note.getContent()));
    var interactor = new CreateNoteInteractor();
    var output = interactor.handle(input);
    var response = new CreateNoteResponse(output.getId().getValue());

    return response;
  }

  @GetMapping("/notes/{id}")
  public String findOne(@PathVariable String id) {
    return "Note with ID: " + id;
  }

  @GetMapping("/notes")
  public String search() {
    return "List of notes";
  }
}

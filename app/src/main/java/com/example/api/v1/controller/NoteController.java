package com.example.api.v1.controller;

import com.example.api.v1.application.note.CreateNoteInput;
import com.example.api.v1.application.note.CreateNoteInteractor;
import com.example.api.v1.application.note.DeleteNoteInput;
import com.example.api.v1.application.note.DeleteNoteInteractor;
import com.example.api.v1.application.note.FindOneNoteInput;
import com.example.api.v1.application.note.FindOneNoteInteractor;
import com.example.api.v1.application.note.SearchNoteInput;
import com.example.api.v1.application.note.SearchNoteInteractor;
import com.example.api.v1.application.note.UpdateNoteInput;
import com.example.api.v1.application.note.UpdateNoteInteractor;
import com.example.api.v1.controller.request.CreateNoteRequest;
import com.example.api.v1.controller.request.SearchNoteRequest;
import com.example.api.v1.controller.request.UpdateNoteRequest;
import com.example.api.v1.controller.response.CreateNoteResponse;
import com.example.api.v1.controller.response.DeleteNoteResponse;
import com.example.api.v1.controller.response.FindOneNoteResponse;
import com.example.api.v1.controller.response.SearchNoteResponse;
import com.example.api.v1.controller.response.UpdateNoteResponse;
import com.example.api.v1.domain.object.NoteContent;
import com.example.api.v1.domain.object.NoteId;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

  private final CreateNoteInteractor createNoteInteractor;
  private final FindOneNoteInteractor findOneNoteInteractor;
  private final SearchNoteInteractor searchNoteInteractor;
  private final UpdateNoteInteractor updateNoteInteractor;
  private final DeleteNoteInteractor deleteNoteInteractor;

  public NoteController(
      CreateNoteInteractor createNoteInteractor,
      FindOneNoteInteractor findOneNoteInteractor,
      SearchNoteInteractor searchNoteInteractor,
      UpdateNoteInteractor updateNoteInteractor,
      DeleteNoteInteractor deleteNoteInteractor) {
    this.createNoteInteractor = createNoteInteractor;
    this.findOneNoteInteractor = findOneNoteInteractor;
    this.searchNoteInteractor = searchNoteInteractor;
    this.updateNoteInteractor = updateNoteInteractor;
    this.deleteNoteInteractor = deleteNoteInteractor;
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
  public SearchNoteResponse search(@ModelAttribute SearchNoteRequest request) {
    var ids = request.getNoteIds();
    var tags = request.getTags();
    var input = new SearchNoteInput(ids, tags);
    var output = searchNoteInteractor.handle(input);

    if (!output.getItems().isPresent()) {
      return new SearchNoteResponse();
    }

    return new SearchNoteResponse(output.getItems().get(), output.getTotal());
  }

  @PatchMapping("/notes/{id}")
  public UpdateNoteResponse update(@PathVariable String id, @RequestBody UpdateNoteRequest note) {
    var input = new UpdateNoteInput(new NoteId(id), new NoteContent(note.getContent()));
    var output = updateNoteInteractor.handle(input);
    if (output == null) {
      return null;
    }
    return new UpdateNoteResponse(output.getId().getValue());
  }

  @DeleteMapping("/notes/{id}")
  public DeleteNoteResponse delete(@PathVariable String id) {
    var input = new DeleteNoteInput(new NoteId(id));
    var output = deleteNoteInteractor.handle(input);
    if (output == null) {
      return null;
    }
    return new DeleteNoteResponse(output.getId().getValue());
  }
}

package com.example.api.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

  @PostMapping("/notes")
  public String create(@RequestBody String note) {
    return "Note created: " + note;
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

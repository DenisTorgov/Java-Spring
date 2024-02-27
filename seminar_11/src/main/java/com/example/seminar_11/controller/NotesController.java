package com.example.seminar_11.controller;

import com.example.seminar_11.model.Note;
import com.example.seminar_11.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class NotesController {
    public NoteService noteService;

    @PostMapping("/notes")
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.CREATED);
    }
    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }
    @GetMapping("/notes/generate")
    public ResponseEntity<List<Note>> generateNotes() {
        return new ResponseEntity<>(noteService.generateNotes(), HttpStatus.OK);
    }
    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getById(@PathVariable Long id) {
        Note noteWithId;
        try {
            noteWithId = noteService.getById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(noteWithId, HttpStatus.OK);
    }
    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@RequestBody Note uNote, @PathVariable Long id) {
        return new ResponseEntity<>(noteService.updateNote(uNote, id), HttpStatus.OK);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}

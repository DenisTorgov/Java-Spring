package ru.gb.seminar12.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.seminar12.model.Note;
import ru.gb.seminar12.services.FileGateway;
import ru.gb.seminar12.services.NoteService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Ну, это наш рест контролёр
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final FileGateway fileGateway;
    @Autowired
    public NoteService noteService;

    /**
     * Добавить заметку
     * @param note заметка
     * @return заметка
     */
    @PostMapping
    public ResponseEntity<List<Note>> addNote(@RequestBody Note note) {
        note.setDateTime(LocalDateTime.now());
        fileGateway.writeToFile("Notes.txt", note.toString());
        noteService.addNote(note);
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity<String> getNotes () {
//        String textOutputChanel = fileGateway.readFile("Notes.txt");
//        return new ResponseEntity<String>(textOutputChanel, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        fileGateway.writeToFile("Notes.txt", "All notes showed");
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }
    @GetMapping("/generate")
    public ResponseEntity<List<Note>> generateNotes() {
        fileGateway.writeToFile("Notes.txt", "New note generateded");
        return new ResponseEntity<>(noteService.generateNotes(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getById(@PathVariable Long id) {
        Note noteWithId;
        try {
            noteWithId = noteService.getById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        fileGateway.writeToFile("Notes.txt", "Note " + id + " showed");
        return new ResponseEntity<>(noteWithId, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@RequestBody Note uNote, @PathVariable Long id) {
        fileGateway.writeToFile("Notes.txt", "Note " + id + " updated");
        return new ResponseEntity<>(noteService.updateNote(uNote, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        fileGateway.writeToFile("Notes.txt", "Note " + id + " deleted");
        return ResponseEntity.ok().build();
    }

}

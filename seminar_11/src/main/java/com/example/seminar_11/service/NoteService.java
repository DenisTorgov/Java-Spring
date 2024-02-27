package com.example.seminar_11.service;

import com.example.seminar_11.model.Note;
import com.example.seminar_11.repository.NotesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {
    public NotesRepository notesRepository;

    public Note addNote(Note note) {
        note.setDateTime(LocalDateTime.now());
        return notesRepository.save(note);
    }
    public List<Note> getAllNotes(){
        return notesRepository.findAll();
    }

    public List<Note> generateNotes(){
        Note note = new Note();
        note.setTitle("note");
        note.setContent("content");
        note.setDateTime(LocalDateTime.now());
        notesRepository.save(note);
        return notesRepository.findAll();
    }
    public Note getById (Long id) {
        return notesRepository.findById(id).orElseThrow(null);
    }
    public Note updateNote (Note note, Long id) {
        Note updNote = notesRepository.findById(id)
                .orElseThrow(null);
        if (updNote.equals(null) ) {
            return null;
        }
        updNote.setTitle(note.getTitle());
        updNote.setContent(note.getContent());
        updNote.setDateTime(LocalDateTime.now());
        return notesRepository.save(updNote);
    }
    public void deleteNote(Long id) {
        notesRepository.delete(notesRepository.getById(id));
    }
}

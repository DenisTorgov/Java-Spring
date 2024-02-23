package com.example.seminar_10.service;

import com.example.seminar_10.model.Note;
import com.example.seminar_10.repository.NotesRepository;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@SpringBootTest
public class NoteServiceIntegrationTest {
    @Autowired
    public NoteService noteService;
    @MockBean
    public NotesRepository notesRepository;

    @Test
    public void getAllNotesTest() {
        Note note = new Note();
        note.setTitle("Test Title");
        note.setContent("Test Content");

        List<Note> expectedNotes = Collections.singletonList(note);

        when(notesRepository.findAll()).thenReturn(expectedNotes);

        List<Note> actualNotes = noteService.getAllNotes();

        assertEquals(expectedNotes, actualNotes);
    }
}

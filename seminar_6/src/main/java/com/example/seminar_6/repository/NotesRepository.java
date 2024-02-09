package com.example.seminar_6.repository;

import com.example.seminar_6.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {

    public Optional<Note> findById(Long id);
}

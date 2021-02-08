package com.minh.notes.repository;

import com.minh.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
     Optional<Note> getNoteById(String id);
}

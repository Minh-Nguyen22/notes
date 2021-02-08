package com.minh.notes.service;

import com.minh.notes.entity.Note;
import com.minh.notes.exception.NoteNotFoundException;
import com.minh.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        notes.sort(new SortByDateAndTime());
        return notes;
    }

    public void saveNote(Note note) {
        noteRepository.save(note);
    }

    public Note getNoteById(String id) {
        Optional<Note> optionalNote = noteRepository.getNoteById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            return note;
        } else {
            throw new NoteNotFoundException();
        }
    }

    public void deleteNoteById(String id) {
        Optional<Note> optionalNote = noteRepository.getNoteById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            noteRepository.delete(note);
        } else {
            throw new NoteNotFoundException();
        }
    }
    public void deleteAllNotes() {
        noteRepository.deleteAll();
    }

    static class SortByDateAndTime implements Comparator<Note> {

        @Override
        public int compare(Note note1, Note note2) {
            return note1.getDateAndTime().compareTo(note2.getDateAndTime());
        }
    }
}

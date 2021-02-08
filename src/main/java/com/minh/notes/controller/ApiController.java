package com.minh.notes.controller;

import com.minh.notes.util.Util;
import com.minh.notes.entity.Note;
import com.minh.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    NoteService noteService;

    public ApiController() {
    }

    @Autowired
    public ApiController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(path = "/api/notes/all")
    public Object[] getAllApiNotes() {
        return noteService.getAllNotes().toArray();
    }

    @GetMapping(path = "/api/notes/{id}")
    public Note getApiNoteById(@PathVariable(value = "id") String id) {
        Note note = noteService.getNoteById(id);
        return note;
    }

    @PostMapping(path = "/api/notes/new")
    public String newApiNote(@RequestBody Note newNote) {
        Note responseNote = new Note();
        responseNote.setId(Util.getUUID());
        responseNote.setDateAndTime(Util.getCurrentDateTime());
        responseNote.setNote(newNote.getNote());
        noteService.saveNote(responseNote);
        return responseNote.getId();
    }

    @GetMapping(path = "/api/notes/delete/{id}")
    public String deleteApiNoteById(@PathVariable("id") String id) {
        noteService.deleteNoteById(id);
        return "Success";
    }

    @GetMapping(path = "/api/notes/delete/all")
    public String deleteApiAllNotes() {
        noteService.deleteAllNotes();
        return "Success";
    }
}

package com.minh.notes.controller;

import com.minh.notes.entity.Note;
import com.minh.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HtmlController {

    NoteService noteService;

    public HtmlController() {
    }

    @Autowired
    public HtmlController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(path = "/notes/{id}", produces = "text/html")
    public String getHtmlNoteById(@PathVariable("id") String id, Model model) {
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return "note";
    }

    @GetMapping(path = "/notes/new", produces = "text/html")
    public String newHtmlNote() {
        return "newnote";
    }

    @GetMapping(path = "/notes/all", produces = "text/html")
    public String getAllHtmlNotes(Model model) {
        List<Note> notes = noteService.getAllNotes();
        model.addAttribute("allNotesStore", notes);
        return "allnotes";
    }

    @GetMapping(path = "/notes/delete/{id}")
    public String deleteNoteById(@PathVariable("id") String id, Model model) {
        noteService.deleteNoteById(id);
        List<Note> notes = noteService.getAllNotes();
        model.addAttribute("allNotesStore", notes);
        return "allnotes";
    }

    @GetMapping(path = "/notes/delete/all")
    public String deleteAllNotes(Model model) {
        noteService.deleteAllNotes();
        List<Note> notes = noteService.getAllNotes();
        model.addAttribute("allNotesStore", notes);
        return "allnotes";
    }
}

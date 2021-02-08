package com.minh.notes.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    private String id;
    private String note;
    private String dateAndTime;

    public Note() {
    }

    public Note(String note, String dateAndTime) {
        this.note = note;
        this.dateAndTime = dateAndTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}

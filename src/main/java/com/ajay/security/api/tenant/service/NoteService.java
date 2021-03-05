package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Note;
import com.ajay.security.api.tenant.repository.NoteRepository;

@Service
@Transactional
public class NoteService {

	@Autowired
	private NoteRepository noteRepository;

	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}

	public Note getOneNote(Integer id) {
		return noteRepository.findById(id).get();
	}

	public Note saveNote(Note note) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (note.getCreatedAt() == null)
			note.setCreatedAt(currentTimestamp);
		note.setUpdatedAt(currentTimestamp);
		return noteRepository.save(note);
	}

	public String deleteOneNote(Note note) {
		String result = null;
		if (noteRepository.existsById(note.getId())) {
			noteRepository.delete(note);
			result = "Note deleted!";
		} else {
			result = "Note not found! Or Already deleted!";
		}
		return result;
	}
}

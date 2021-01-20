package com.ajay.security.api.tenant.service;

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

	public String saveNote(Note note) {
		return noteRepository.save(note) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateNote(Note note) {
		return noteRepository.save(note) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneNote(Integer id) {
		noteRepository.deleteById(id);
		return " successfully deleted!";
	}
}

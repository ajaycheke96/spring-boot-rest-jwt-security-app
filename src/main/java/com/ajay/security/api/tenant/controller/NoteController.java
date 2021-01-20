package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.Note;
import com.ajay.security.api.tenant.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@GetMapping("/all")
	public List<Note> getAllNote() {
		return noteService.getAllNotes();
	}

	@GetMapping("/one/{id}")
	public Note getOneNote(@PathVariable Integer id) {
		return noteService.getOneNote(id);
	}

	@PostMapping("/save")
	public String saveNote(@RequestBody Note note) {
		return noteService.saveNote(note);
	}

	@PutMapping("/update")
	public String updateNote(@RequestBody Note note) {
		return noteService.updateNote(note);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneNote(@PathVariable Integer id) {
		return noteService.deleteOneNote(id);
	}
}

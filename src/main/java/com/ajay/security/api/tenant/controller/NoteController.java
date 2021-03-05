package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Note;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.NoteService;

@RestController
@RequestMapping("/note")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NoteController {

	@Autowired
	private NoteService noteService;

	@GetMapping("/listAllNote")
	public ApiResponse getAllNote() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Note", noteService.getAllNotes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Note Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneNote(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Note", noteService.getOneNote(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Note Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveNote")
	public ApiResponse saveNote(@RequestBody Note note) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Note saved!", noteService.saveNote(note));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Note Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateNote")
	public ApiResponse updateNote(@RequestBody Note note) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Note updated!", noteService.saveNote(note));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Note Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteNote")
	public ApiResponse deleteOneNote(@RequestBody Note note) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, noteService.deleteOneNote(note), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Note Service exception : " + e.getLocalizedMessage());
		}
	}
}

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

import com.ajay.security.api.tenant.entity.Todo;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.TodoService;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/listAllTodo")
	public ApiResponse getAllTodo() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Todo", todoService.getAllTodos());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Todo Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneTodo(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Todo", todoService.getOneTodo(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Todo Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveTodo")
	public ApiResponse saveTodo(@RequestBody Todo todo) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Todo saved!", todoService.saveTodo(todo));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Todo Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateTodo")
	public ApiResponse updateTodo(@RequestBody Todo todo) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Todo updated!", todoService.saveTodo(todo));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Todo Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteTodo")
	public ApiResponse deleteOneTodo(@RequestBody Todo todo) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, todoService.deleteOneTodo(todo), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Todo Service exception : " + e.getLocalizedMessage());
		}
	}
}

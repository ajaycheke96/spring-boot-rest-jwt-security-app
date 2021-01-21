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

import com.ajay.security.api.tenant.entity.Todo;
import com.ajay.security.api.tenant.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/all")
	public List<Todo> getAllTodo() {
		return todoService.getAllTodos();
	}

	@GetMapping("/one/{id}")
	public Todo getOneTodo(@PathVariable Integer id) {
		return todoService.getOneTodo(id);
	}

	@PostMapping("/save")
	public String saveTodo(@RequestBody Todo todo) {
		return todoService.saveTodo(todo);
	}

	@PutMapping("/update")
	public String updateTodo(@RequestBody Todo todo) {
		return todoService.updateTodo(todo);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTodo(@PathVariable Integer id) {
		return todoService.deleteOneTodo(id);
	}
}

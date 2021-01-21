package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Todo;
import com.ajay.security.api.tenant.repository.TodoRepository;

@Service
@Transactional
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	public Todo getOneTodo(Integer id) {
		return todoRepository.findById(id).get();
	}

	public String saveTodo(Todo todo) {
		return todoRepository.save(todo) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateTodo(Todo todo) {
		return todoRepository.save(todo) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneTodo(Integer id) {
		todoRepository.deleteById(id);
		return " successfully deleted!";
	}
}

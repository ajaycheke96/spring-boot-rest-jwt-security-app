package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Todo saveTodo(Todo todo) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (todo.getCreatedAt() == null)
			todo.setCreatedAt(currentTimestamp);
		todo.setUpdatedAt(currentTimestamp);
		return todoRepository.save(todo);
	}

	public String deleteOneTodo(Todo todo) {
		String result = null;
		if (todoRepository.existsById(todo.getId())) {
			todoRepository.delete(todo);
			result = " Todo deleted!";
		} else {
			result = "Todo Not Found! or Already deleted!";
		}
		return result;
	}
}

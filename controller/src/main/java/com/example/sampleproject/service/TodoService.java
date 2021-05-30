package com.example.sampleproject.service;

import java.util.List;

import com.example.sampleproject.datamodel.Todo;

public interface TodoService {
	
	List<Todo> getAllTodos();
	
	void deleteTodo(Long id);
	
	Todo getTodo(Long id);
	
	void updateTodo(Todo todo);

}

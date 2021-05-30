package com.example.sampleproject.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sampleproject.daoservice.TodoServiceDao;
import com.example.sampleproject.datamodel.Todo;
import com.example.sampleproject.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	TodoServiceDao todoServiceDao;
	
	@Override
	public List<Todo> getAllTodos() {
		List<Todo> todoList = new ArrayList<>();	
		Iterable<Todo> todoitr = todoServiceDao.getAllTodos();
		for(Todo todo : todoitr) {
			todoList.add(todo);
		}
		return todoList;
	}

	@Override
	public void deleteTodo(Long id) {
		todoServiceDao.deleteTodo(id);
	}

	@Override
	public Todo getTodo(Long id) {
		Optional<Todo> todo = todoServiceDao.getTodo(id);
		return todo.get();
	}

	@Override
	public void updateTodo(Todo todo) {
		Optional<Todo> todoOp = todoServiceDao.getTodo(todo.getId());
		Todo oldTodo = todoOp.get();
		oldTodo = todo;
		todoServiceDao.saveTodo(oldTodo);
	}	
}

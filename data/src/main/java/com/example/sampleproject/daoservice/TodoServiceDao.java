package com.example.sampleproject.daoservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sampleproject.dao.TodoDAO;
import com.example.sampleproject.datamodel.Todo;

@Component
public class TodoServiceDao {

	@Autowired
	TodoDAO todoDAO;
	
	public Iterable<Todo> getAllTodos(){
		return todoDAO.findAll();
		//return todoDAO.findAllById(todo.getId());
	}
	
	public void deleteTodo(Long id){
		todoDAO.deleteById(id);
		//return todoDAO.findAllById(todo.getId());
	}
	
	public Optional<Todo> getTodo(Long id){
		return todoDAO.findById(id);
		//return todoDAO.findAllById(todo.getId());
	}
	
	public void saveTodo(Todo todo){
		todoDAO.save(todo);
		//return todoDAO.findAllById(todo.getId());
	}
}

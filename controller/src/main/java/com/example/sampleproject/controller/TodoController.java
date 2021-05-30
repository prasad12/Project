package com.example.sampleproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sampleproject.datamodel.Todo;
import com.example.sampleproject.service.TodoService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoService.getAllTodos();
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable String username,@PathVariable Long id){
		todoService.deleteTodo(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,@PathVariable Long id){
		return todoService.getTodo(id);
	}
	
	@PostMapping("/users/{username}/todos/updatetodo")
	public ResponseEntity<?> getTodo(@PathVariable String username,@RequestBody Todo todo){
		todoService.updateTodo(todo);
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
	}
	
}

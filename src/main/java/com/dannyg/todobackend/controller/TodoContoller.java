package com.dannyg.todobackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dannyg.todobackend.model.Todo;
import com.dannyg.todobackend.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoContoller {

	private TodoService todoService;

	public TodoContoller(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@PostMapping
	public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo){
		return new ResponseEntity<Todo>(todoService.saveTodo(todo), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Todo> getTodos(){
		return todoService.getAllTodos();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") long id){
		return new ResponseEntity<Todo>(todoService.getTodoById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Todo> updateTodoById(@PathVariable("id") long id, @RequestBody Todo todo){
		return new ResponseEntity<Todo>(todoService.updateTodo(todo, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable("id") long id){
		todoService.deleteTodo(id);
		return new ResponseEntity<String>("Todo deleted succesfully!", HttpStatus.OK);
	}
}

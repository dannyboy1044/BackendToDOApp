package com.dannyg.todobackend.service;

import java.util.List;

import com.dannyg.todobackend.model.Todo;


public interface TodoService {

	Todo saveTodo(Todo todo);
	
	List<Todo> getAllTodos();
	
	Todo getTodoById(long id);
	
	Todo updateTodo(Todo todo, long id);
	
	void deleteTodo(long id);
}

package com.dannyg.todobackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dannyg.todobackend.exceptions.ResourceNotFoundException;
import com.dannyg.todobackend.model.Todo;
import com.dannyg.todobackend.repository.TodoRepository;
import com.dannyg.todobackend.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{
	
	private TodoRepository todoRepo;
	
	

	public TodoServiceImpl(TodoRepository todoRepo) {
		super();
		this.todoRepo = todoRepo;
	}

	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepo.save(todo);
	}

	@Override
	public List<Todo> getAllTodos() {
		return todoRepo.findAll();
	}

	@Override
	public Todo getTodoById(long id) {
		return todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo", "Id", id));
	}

	@Override
	public Todo updateTodo(Todo todo, long id) {
		Todo todoUpdate = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo", "Id", id));
		todoUpdate.setTodo(todo.getTodo());
		todoRepo.save(todoUpdate);
		return todoUpdate;
	}

	@Override
	public void deleteTodo(long id) {
		todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo", "Id", id));
		todoRepo.deleteById(id);
	}

}

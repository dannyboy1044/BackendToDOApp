package com.dannyg.todobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dannyg.todobackend.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}

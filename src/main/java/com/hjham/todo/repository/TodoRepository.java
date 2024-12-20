package com.hjham.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hjham.todo.domain.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
  
}

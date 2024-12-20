package com.hjham.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hjham.todo.dto.TodoListDto;
import com.hjham.todo.dto.TodoWriteDto;
import com.hjham.todo.repository.TodoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoService {
  private final TodoRepository repository;
  // 목록조회
  public List<TodoListDto> list() {
    return repository.findAll().stream().map(TodoListDto::new).toList();
  }
  public void write(TodoWriteDto dto) {
    repository.save(dto.todoEntity());
  }
  // 등록
  
  // 삭제


}

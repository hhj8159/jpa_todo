package com.hjham.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.hjham.todo.domain.TodoEntity;
import com.hjham.todo.dto.TodoListDto;
import com.hjham.todo.dto.TodoWriteDto;
import com.hjham.todo.repository.TodoRepository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

// @AllArgsConstructor
@Service
public class TodoService {
  private TodoRepository repository;
  private EntityManager manager;

  @PostConstruct
  public void init() {
    repository.saveAll(
      Stream.of(
        TodoEntity.builder().task("첫일").build(),
        TodoEntity.builder().task("둘일").build(),
        TodoEntity.builder().task("셋일").build()
      ).toList()
    );    
  }

  // 목록조회
  public List<TodoListDto> list() {
    // return repository.findAll(Sort.by(Direction.DESC, "id")).stream().map(TodoListDto::new).toList();
    // return repository.findAll().stream().map(TodoListDto::new).toList();
    // return repository.findByOrderByTaskDesc().stream().map(TodoListDto::new).toList();
    return repository.findAll(Sort.by(Order.desc("task"), Order.asc("id"))).stream().map(TodoListDto::new).toList();

  }

  // 등록
  public void write(TodoWriteDto dto) {
    repository.save(dto.todoEntity());
  }
  
  // 삭제
  public void remove(Long id) {
    repository.deleteById(id);  
  }

  // 수정
  @Transactional
  public void modify(Long id) {
    // Optional<TodoEntity> entity = repository.findById(id);
    // entity.ifPresent(e -> { e.setDone(true); repository.save(e); });
    // repository.save(TodoEntity.builder().id(id).done(true).task("직접 준 것").build());

    // 수정 Using EntityManager의 경우
    manager.find(TodoEntity.class, id).setDone(true);
    // repository.updateTodoDoneById(id);
  }

}

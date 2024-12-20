package com.hjham.todo.dto;

import com.hjham.todo.domain.TodoEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoWriteDto {
  private String task;

  public TodoWriteDto(TodoEntity entity) {
    task = entity.getTask();
  }

  // dto >> entity
  public TodoEntity todoEntity() {
    return TodoEntity.builder().task(task).build();
  }

}

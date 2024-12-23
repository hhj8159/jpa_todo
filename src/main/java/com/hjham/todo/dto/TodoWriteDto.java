package com.hjham.todo.dto;

import com.hjham.todo.domain.TodoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TodoWriteDto {
  private Long id;
  private String task;
  private boolean done;

  public TodoWriteDto(TodoEntity entity) {
    id = entity.getId();
    task = entity.getTask();
    done = entity.isDone();
  }

  // dto >> entity
  public TodoEntity todoEntity() {
    return TodoEntity.builder().task(task).build();
  }

}

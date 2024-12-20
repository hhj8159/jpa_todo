package com.hjham.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hjham.todo.dto.TodoWriteDto;
import com.hjham.todo.service.TodoService;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class TodoController {
  @Autowired
  private TodoService service;
  @GetMapping("todos")
  public String list(Model model) {
    model.addAttribute("todos", service.list());
    return "todo-list";
  }

  @PostMapping("todos")
  public String write(TodoWriteDto dto) {
    log.info(dto);
    service.write(dto);
    return "rediect:todos";
  }
  
  
  
}

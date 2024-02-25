package com.pv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.pv.entity.Todo;
import com.pv.service.TodoService;


@RestController
@RequestMapping("/api/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todos")
	public List<Todo> getAllTodos()
	{
		return todoService.getAllTodos();
	}
	
	
	@PostMapping("/todos")
	public String addTodo(@RequestBody Todo todo)
	{
		return todoService.addTodo(todo);
	}
	
	@GetMapping("/todos/{id}")
	   public Todo getByTodoId(@PathVariable("id") Integer todoId)
	   {
		   return todoService.getByTodoId(todoId);
	   }
	
	 @PutMapping("/todos/{id}")
	   public ResponseEntity<Object> updateTodo(@PathVariable("id") Integer todoId, @RequestBody Todo todo)
	   {
		   return todoService.updateTodo(todoId, todo);
	   }
	 
	 @DeleteMapping("/todos/{id}")
	   public ResponseEntity<Object> deleteTodo(@PathVariable("id") Integer todoId)
	   {
		   return todoService.deleteTodo(todoId);
	   }
}

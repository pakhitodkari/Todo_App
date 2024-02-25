package com.pv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pv.entity.Todo;
import com.pv.exception.ResponseStatusException;
import com.pv.reopsitory.TodoRepository;



@Service
public class TodoService 
{
	@Autowired
	private TodoRepository todoRepo;
	
	
	//For getting all todos
   public List<Todo> getAllTodos()
   {
	   
	   return todoRepo.findAll();
   }
   
 
   
 //For adding  todo
   public String addTodo(Todo todo)
   {
	   todoRepo.saveAndFlush(todo);
	   return "Todo Added Successfully";
   }
    
   
 //For getting todo by id
   public Todo getByTodoId(Integer todoId)
   {
	   return todoRepo.findById(todoId).orElseThrow(() -> new ResponseStatusException("Todo is not Present in database"));
   }
  
    
   //For updating todo
   public ResponseEntity<Object> updateTodo(Integer todoId, Todo todo)
   {
       if(!todoRepo.existsById(todoId))
       {
    	   throw new ResponseStatusException("Todo is not Present in database");
       }
        
       Todo todos = todoRepo.findById(todoId).orElseThrow(() -> new ResponseStatusException("Todo is not Present in database"));
       
      todos.setId(todo.getId());
      todos.setPriority(todo.getPriority());
      todos.setStatus(todo.getStatus());
      todos.setTodo(todo.getTodo());
       
       todoRepo.saveAndFlush(todos);
	   return new ResponseEntity<>("Todo Updated Successfully", HttpStatus.OK);
   }
   
   //For deleting todo
   public ResponseEntity<Object> deleteTodo(Integer todoId)
   {
	   if(!todoRepo.existsById(todoId))
       {
    	   throw new ResponseStatusException("Todo is not Present in database");
       }
	   
	   todoRepo.deleteById(todoId);
	   
	   return new ResponseEntity<>("Todo Deleted Successfully", HttpStatus.ACCEPTED);
   }
   
 
}
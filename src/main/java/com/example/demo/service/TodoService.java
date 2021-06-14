package com.example.demo.service;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public void createTodo(Todo todo){
        todoRepository.save(todo);
    }

    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public void editTodo(Todo todo){
        todoRepository.save(todo);
    }

    public void deleteTodo(int id){
        todoRepository.deleteById(id);
    }

    public void deleteAll(){
        todoRepository.deleteAll();
    }
}

package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
class WebController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todo")
    public ModelAndView index(Model model){
        List<Todo> todos = todoService.getTodos();
        model.addAttribute("todos",todos);
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getTodo(Model model,@PathVariable("id") Integer id){
        List<Todo> todos = todoService.getTodos();
        model.addAttribute(todos);
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/todo/new")
    public ModelAndView createTodo()
    {
        return new ModelAndView("create_todo");
    }

    @PostMapping("/todo/new")
    public ModelAndView newTodo(@RequestBody Todo todo){
        System.out.println(todo);
        todoService.createTodo(todo);
        return new ModelAndView("redirect:/todo");
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@RequestParam("id") Integer id)
    {
        todoService.deleteTodo(id);
    }
}
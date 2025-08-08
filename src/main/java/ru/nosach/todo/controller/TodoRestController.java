package ru.nosach.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.*;
import ru.nosach.todo.entity.Todo;
import ru.nosach.todo.entity.Todo.Status;
import ru.nosach.todo.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoRestController {

    private final TodoService todoService;

    @GetMapping("")
    public List<Todo> todos() {
        return todoService.getAll();
    }

    @GetMapping("/status/{status}")
    public List<Todo> todos(@PathVariable Status status) {
        return todoService.getAllByStatus(status);
    }

    @GetMapping("/sort/{sortBy}")
    public List<Todo> todos(@PathVariable String sortBy, @RequestParam(defaultValue = "ASC") Direction direction) {
        return todoService.getAllSorted(direction, sortBy);
    }

    @PostMapping("/add")
    public Todo saveTodo(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @PostMapping("/edit/{id}")
    public Todo editTodo(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
    }
}

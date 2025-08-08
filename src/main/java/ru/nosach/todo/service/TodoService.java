package ru.nosach.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import ru.nosach.todo.entity.Todo;
import ru.nosach.todo.entity.Todo.Status;
import ru.nosach.todo.repository.TodoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public List<Todo> getAllByStatus(Status status) {
        return todoRepository.findAllByStatus(status);
    }

    public List<Todo> getAllSorted(Direction direction, String sortBy) {
        return todoRepository.findAll(Sort.by(direction, sortBy));
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}

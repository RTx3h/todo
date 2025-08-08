package ru.nosach.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nosach.todo.entity.Todo;
import ru.nosach.todo.entity.Todo.Status;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByStatus(Status status);
}

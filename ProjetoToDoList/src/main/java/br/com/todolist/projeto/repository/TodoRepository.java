package br.com.todolist.projeto.repository;

import br.com.todolist.projeto.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}

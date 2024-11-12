package br.com.todolist.projeto.service;

import br.com.todolist.projeto.entity.Todo;
import br.com.todolist.projeto.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").ascending().and(
                Sort.by("nome").descending());
         return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todoUpdadte) {
        todoRepository.save(todoUpdadte);
        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}

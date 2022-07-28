package repository;

import entity.TodoList;

public interface TodoListRepository {

    TodoList[] getAll();

    void addTodo(TodoList todoList);

    boolean removeTodo(Integer number);

}

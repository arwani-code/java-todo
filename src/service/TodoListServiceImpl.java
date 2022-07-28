package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] todos = todoListRepository.getAll();

        for (var i = 0; i < todos.length; i++) {
            var todo = todos[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo.getTodoList());
            }
        }

    }

    @Override
    public void addTodoList(String todo) {
        TodoList todolist = new TodoList(todo);
        todoListRepository.addTodo(todolist);
        System.out.println("SUKSES MENAMBAHKAN TODO : " + todo);
    }

    @Override
    public boolean removeTodoList(Integer number) {
        boolean deleteTodo = todoListRepository.removeTodo(number);

        if(deleteTodo){
            System.out.println("SUKSES DELETE TODO : " + number);
        }else {
            System.out.println("GAGAL DELET TODO : " + number);
        }

        return deleteTodo;
    }
}

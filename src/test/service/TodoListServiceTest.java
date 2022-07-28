package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {

    public static void main(String[] args) {
        testDeleteTodo();
    }

    public static void testShowTodoList(){
        TodoListRepositoryImpl todoListRepositoryImpl = new TodoListRepositoryImpl();
        todoListRepositoryImpl.data[0] = new TodoList("Belajar Java");
        todoListRepositoryImpl.data[1] = new TodoList("Belajar Java OOP");
        todoListRepositoryImpl.data[2] = new TodoList("Belajar Java Generic");
        TodoListService todoListService = new TodoListServiceImpl(todoListRepositoryImpl);

        todoListService.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standard Class");

        todoListService.showTodoList();
    }

    public static void testDeleteTodo(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standard Class");

        todoListService.showTodoList();
        todoListService.removeTodoList(4);
        todoListService.showTodoList();
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
        todoListService.removeTodoList(1);
        todoListService.showTodoList();
        todoListService.removeTodoList(1);
        todoListService.showTodoList();
    }
}

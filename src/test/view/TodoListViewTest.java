package test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class TodoListViewTest {

    public static void main(String[] args) {
        testViewRemoveTodo();
    }

    public static void testViewShowTodo(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar Golang Dasar");
        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Nnode Dasar");

        todoListView.showTodoList();
    }

    public static void testViewAddTodo(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.addTodoList();
        todoListView.showTodoList();
    }

    public static void testViewRemoveTodo(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar Golang Dasar");
        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Nnode Dasar");

        todoListView.removeTodoList();

        todoListView.showTodoList();
    }

}

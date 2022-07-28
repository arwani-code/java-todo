package view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

import static utils.Input.inputData;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService){
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        label:
        while (true) {
            todoListService.showTodoList();

            System.out.println("1. Add Todo");
            System.out.println("2. Remove Todo");
            System.out.println("x. exit");

            var input = inputData("Pilih");

            switch (input) {
                case "1":
                    addTodoList();
                    break;
                case "2":
                    removeTodoList();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println("Pilihan tidak di mengerti");
                    break;
            }
        }
    }

    public void addTodoList(){
        var input = inputData("Todo");
        if(input.isEmpty()){
            System.out.println("Masukan Todo");
        }else{
            todoListService.addTodoList(input);
        }
    }

    public void removeTodoList(){
        String inputTodo = inputData("DELETE TODO KE");
        boolean success = todoListService.removeTodoList(Integer.valueOf(inputTodo));

        if(inputTodo.isEmpty()){
            System.out.println("SELECT NUMBER TODO");
        }else{
            todoListService.removeTodoList(Integer.valueOf(inputTodo));
        }

    }

}

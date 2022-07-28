package entity;

public class TodoList {

    private String todo;

    public TodoList(){

    }

    public TodoList(String todo){
        this.todo = todo;
    }

    public String getTodoList() {
        return todo;
    }

    public void setTodoList(String todoList) {
        this.todo = todoList;
    }
}

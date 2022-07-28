package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {

    public TodoList[] data = new TodoList[10];

    public boolean isFullTodo(){
        var isFullTodo = true;

        for (TodoList value : data) {
            if (value == null) {
                isFullTodo = false;
                break;
            }
        }

        return isFullTodo;
    }

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public void resizeFull(){
        if (isFullTodo()) {
            var temp = data;
            data = new TodoList[data.length * 2];

            System.arraycopy(temp, 0, data, 0, temp.length);
        }
    }

    @Override
    public void addTodo(TodoList todoList) {
        resizeFull();

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todoList;
                break;
            }
        }
    }

    @Override
    public boolean removeTodo(Integer number) {
        if ((number - 1) >= data.length) {
            System.out.println("Todo number not found");
            return false;
        } else if (data[number - 1] == null) {
            System.out.println("Todo number not found");
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}

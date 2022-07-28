import java.util.Scanner;

public class TodoListApp {

    public static String[] todos = new String[10];
    public static Scanner textInput = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int value = 1;
        if(input.hasNext()){
            System.out.println(value + " " + input.nextLine());
            value += 1;
        }
    }

    public static void getTodo() {
        for (var i = 0; i < todos.length; i++) {
            var todo = todos[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testGetTodo() {
        todos[0] = "Hari ini belajar Java";
        todos[1] = "Belajar golang Besok";
        getTodo();
    }

    public static void addTodo(String todo) {
        var isFullTodo = true;

        for (String s : todos) {
            if (s == null) {
                isFullTodo = false;
                break;
            }
        }

        if (isFullTodo) {
            var temp = todos;
            todos = new String[todos.length * 2];

            for (int i = 0; i < temp.length; i++) {
                todos[i] = temp[i];
            }
        }

        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                todos[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodo() {
        for (int i = 0; i < 25; i++) {
            addTodo("Test " + i);
        }
        getTodo();
    }

    public static boolean removeTodo(Integer number) {
        if ((number - 1) >= todos.length) {
            System.out.println("Todo number not found");
            return false;
        } else if (todos[number - 1] == null) {
            System.out.println("Todo number not found");
            return false;
        } else {
            for (int i = (number - 1); i < todos.length; i++) {
                if (i == (todos.length - 1)) {
                    todos[i] = null;
                } else {
                    todos[i] = todos[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodo() {
        addTodo("Satu");
        addTodo("Dua");
        addTodo("Tiga");
        addTodo("Empat");
        addTodo("Lima");

        removeTodo(4);

        getTodo();
    }

    public static String inputData(String info) {
        System.out.print(info + " : ");
        return textInput.nextLine();
    }

    public static void testInputData() {
        String inputData = inputData("todo");
        System.out.println(inputData);
    }

    public static void viewAllTodo() {
        while (true) {
            getTodo();

            System.out.println("1. Add Todo");
            System.out.println("2. Remove Todo");
            System.out.println("x. exit");

            var input = inputData("Pilih");

            if (input.equals("1")) {
                viewAddTodo();
            } else if (input.equals("2")) {
                viewRemoveTodo();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak di mengerti");
            }
        }
    }

    public static void testViewAllTodo() {
        viewAllTodo();
    }

    public static void viewAddTodo() {
        var input = inputData("Todo");
        addTodo(input);
    }

    public static void viewRemoveTodo() {
        var input = inputData("Delete todo");
        removeTodo(Integer.valueOf(input));
    }
}

package utils;

import java.util.Scanner;

public class Input {

    public static Scanner textInput = new Scanner(System.in);

    public static String inputData(String info) {
        System.out.print(info + " : ");
        return textInput.nextLine();
    }

}

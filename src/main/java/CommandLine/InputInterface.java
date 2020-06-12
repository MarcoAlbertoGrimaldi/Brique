package CommandLine;

import java.util.Scanner;
import java.util.regex.Pattern;

public interface InputInterface {

    Scanner scanner = new Scanner(System.in);

    default boolean isValid(String input, String pattern) {
        return Pattern.matches(pattern, input);
    }

    default String getInput(String request_msg, String err_msg, String pattern){
        System.out.println(request_msg);
        String input = null;
        boolean valid = false;
        while(!valid){
            input = scanner.next();
            if(isValid(input, pattern)) valid = true;
            else notValid(err_msg);
        }
        return input;
    }

    default void notValid(String error){
        System.out.println(error);
    }

}

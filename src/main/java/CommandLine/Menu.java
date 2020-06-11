package CommandLine;

public class Menu {

    final String menuOptions;
    final String req_msg = "Type the corresponding number to choose an option.";
    final String err_message = "Not valid, please type a number between 0 and 3:";
    final String pattern = "[0-3]";

    public Menu() {
        String newLine = System.getProperty("line.separator");
        menuOptions = "Menu:"
                + newLine + "'0' Single player as Black;"
                + newLine + "'1' Single player as White;"
                + newLine + "'2' Multiplayer;"
                + newLine + "'3' Quit.";
    }

    public void printMenu() {
        System.out.println(menuOptions);
    }

    public String getReq_msg() {
        return req_msg;
    }

    public String getErr_message() {
        return err_message;
    }

    public String getPattern() {
        return pattern;
    }


}
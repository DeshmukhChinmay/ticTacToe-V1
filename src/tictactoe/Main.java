package tictactoe;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        introMessage();
        GameLogic.initialiseCanvas();
        displayMainMenuOptions();
        userInput();
//        GameLogic.displayCanvas();
//        GameLogic.addMove('X', 1, 2);
    }

    private static void introMessage() {
        System.out.println("=========================");
        System.out.println("       TIC TAC TOE       ");
        System.out.println("=========================");
    }

    private static void displayMainMenuOptions() {
        System.out.println("Please enter the number of the option you want to choose:");
        System.out.println("(1) Play PvP");
        System.out.println("(2) Exit");
    }

    private static void userInput() {

        Scanner userInputReader = new Scanner(System.in);
        String input = userInputReader.nextLine();
        boolean validInput = false;

        while (!validInput) {
            if (input.equals("1")) {
                GameLogic.displayCanvas();
            } else if (input.equals("2")) {
                validInput = true;
                System.exit(0);
            } else {
                System.out.println("Please enter a valid number!");
                displayMainMenuOptions();
                input = userInputReader.nextLine();
            }
        }


    }

}


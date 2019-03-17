package tictactoe;

import java.util.*;

public class Main {

    private static State currentState = State.PLAY;
    private static Player currentPlayer = Player.X;
    private static int moves;

    public static void main(String[] args) {
        introMessage();
        GameLogic.initialiseCanvas();
        mainMenu();
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

    private static void displayPlayOptions() {
        System.out.println("\"Player " + currentPlayer.toString() + "\" - Please enter the cell you want to play(1-9): ");
    }

    private static void displayError() {
        System.out.println("Invalid input");
    }

    private static void mainMenu() {

        displayMainMenuOptions();
        Scanner userInputReader = new Scanner(System.in);
        String input = userInputReader.nextLine();
        boolean validInput = false;

        while (!validInput) {
            if (input.equals("1")) {
                GameLogic.displayCanvas();
                validInput = true;
                playPVP();
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

    private static void playPVP() {

        Scanner userInputReader = new Scanner(System.in);
        int input;
        currentState = State.PLAY;
        moves = 1;

        while (currentState == State.PLAY) {
            displayPlayOptions();

            try {
                input = Integer.parseInt(userInputReader.nextLine());
                if (input < 1 || input > 9) {
                    displayError();
                } else {
                    if (GameLogic.addMove(input, currentPlayer)) {
                        if (GameLogic.checkCol(currentPlayer) || GameLogic.checkRow(currentPlayer) || GameLogic.checkDiagonal(currentPlayer)) {
                            currentState = State.WIN;
                        } else {
                            if (currentPlayer == Player.X) {
                                currentPlayer = Player.O;
                            } else {
                                currentPlayer = Player.X;
                            }
                        }
                        moves++;
                        if (moves > 9) {
                            currentState = State.DRAW;
                        }
                    } else {
                        System.out.println("Cell already taken. Enter another number(0-9).");
                    }
                }
            } catch (NumberFormatException e) {
                displayError();
                continue;
            }

        }

        if (currentState == State.WIN) {
            System.out.println("Player " + currentPlayer.toString() + " has won!");
            gameReset();
        } else {
            System.out.println("The game is a draw!");
            gameReset();
        }

    }

    private static void gameReset() {
        System.out.println();
        System.out.println("-------------------------");
        currentPlayer = Player.X;
        GameLogic.clearCanvas();
        mainMenu();
    }

}


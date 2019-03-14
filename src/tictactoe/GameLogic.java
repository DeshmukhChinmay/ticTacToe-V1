package tictactoe;

public class GameLogic {

    private static char[][] canvas = new char[3][3];

    public static void initialiseCanvas() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                canvas[i][j] = '-';
            }
        }
    }

    public static void displayCanvas() {

        System.out.println("-------------------------");

        for (int i = 0; i < 3; i++) {

            System.out.println("|       |       |       |");
            System.out.print("|   ");

            for (int j = 0; j < 3; j++) {

                System.out.print(canvas[i][j] + "   |   ");

            }

            System.out.println();
            System.out.println("|       |       |       |");
            System.out.println("-------------------------");

        }


    }

    public static void addMove(char move, int row, int col) {

        canvas[row][col] = move;
        displayCanvas();

    }

}

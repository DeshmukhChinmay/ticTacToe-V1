package tictactoe;

public class GameLogic {

    private static Cell[][] canvas = new Cell[3][3];

    public static void initialiseCanvas() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                canvas[i][j] = new Cell(Player.NONE);
            }
        }
    }

    public static void clearCanvas() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                canvas[i][j].setPlayer(Player.NONE);
            }
        }
    }

    public static void displayCanvas() {

        System.out.println("-------------------------");

        for (int i = 0; i < 3; i++) {

            System.out.println("|       |       |       |");
            System.out.print("|   ");

            for (int j = 0; j < 3; j++) {

                System.out.print(canvas[i][j].getPlayerString() + "   |   ");

            }

            System.out.println();
            System.out.println("|       |       |       |");
            System.out.println("-------------------------");

        }


    }

    public static boolean addMove(int cell, Player player) {

        boolean successful = false;

        if (canvas[(cell-1)/3][(cell-1)%3].getPlayer() == Player.NONE) {
            canvas[(cell-1)/3][(cell-1)%3].setPlayer(player);
            displayCanvas();
            successful = true;
        }

        return successful;

    }

    public static boolean checkRow(Player player) {

        boolean result = false;

        for (int i = 0; i < 3; i++) {
            if ((canvas[i][0].getPlayer() == player && canvas[i][0].getPlayer() != Player.NONE)
                    && (canvas[i][1].getPlayer() == player && canvas[i][1].getPlayer() != Player.NONE)
                    && (canvas[i][2].getPlayer() == player && canvas[i][2].getPlayer() != Player.NONE)) {
                result = true;
                break;
            }
        }

        return result;

    }

    public static boolean checkCol(Player player) {

        boolean result = false;

        for (int i = 0; i < 3; i++) {
            if ((canvas[0][i].getPlayer() == player && canvas[0][i].getPlayer() != Player.NONE)
                    && (canvas[1][i].getPlayer() == player && canvas[1][i].getPlayer() != Player.NONE)
                    && (canvas[2][i].getPlayer() == player && canvas[2][i].getPlayer() != Player.NONE)) {
                result = true;
                break;
            }
        }

        return result;

    }

    public static boolean checkDiagonal(Player player) {

        boolean result = false;

        if ((canvas[0][0].getPlayer() == player && canvas[0][0].getPlayer() != Player.NONE)
                && (canvas[1][1].getPlayer() == player && canvas[1][1].getPlayer() != Player.NONE)
                && (canvas[2][2].getPlayer() == player && canvas[2][2].getPlayer() != Player.NONE)) {
            result = true;
        } else if ((canvas[2][0].getPlayer() == player && canvas[2][0].getPlayer() != Player.NONE)
                && (canvas[1][1].getPlayer() == player && canvas[1][1].getPlayer() != Player.NONE)
                && (canvas[0][2].getPlayer() == player && canvas[0][2].getPlayer() != Player.NONE)) {
            result = true;
        }

        return result;

    }


}

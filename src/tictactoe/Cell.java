package tictactoe;

public class Cell {

    private Player player;

    public Cell(Player player) {
        this.player = player;
    }


    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getPlayerString() {
        if (this.player == Player.NONE) {
            return "-";
        } else {
            return this.player.toString();
        }
    }

    public Player getPlayer() {
        return this.player;
    }

}

package Mahjong;

import lombok.Getter;
import lombok.Setter;

import java.util.Queue;

@Getter @Setter

public class Referee {

    private Board mahjongBoard;

    public Referee(Board board) {
        this.mahjongBoard = board;
    }

    public Tile deal() {
        Queue<Tile> wall = this.mahjongBoard.getWall();
        return wall.poll();
    }
}

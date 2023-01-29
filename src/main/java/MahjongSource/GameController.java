package MahjongSource;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter

public class GameController {

    private Board mahjongBoard;
    private int currentPlayerPosition;

    public GameController(Board board) {
        this.mahjongBoard = board;
        this.currentPlayerPosition = 0;
    }

    public GameController() {
        this(new Board());
    }

    public void deal() {
        Queue<Tile> wall = this.mahjongBoard.getWall();
        Player currentPlayer = this.mahjongBoard.getSeatPositions()[this.currentPlayerPosition];
        currentPlayer.draw(wall.poll());
    }

    public void startingDeal() {
        Player[] players = mahjongBoard.getSeatPositions();
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < Rules.STARTING_HAND_SIZE; j++) {
                deal();
            }
            nextTurn();
        }
    }

    public void discard(Tile tile) {
        Player currentPlayer = this.mahjongBoard.getSeatPositions()[this.currentPlayerPosition];
        currentPlayer.discardTile(tile);
    }

    public void nextTurn() {
        this.currentPlayerPosition = (this.currentPlayerPosition + 1) % 4;
    }

    public Tile checkForMatchingTile(String suit, String num) {
        Player currentPlayer = this.mahjongBoard.getSeatPositions()[this.currentPlayerPosition];
        List<Tile> hand = currentPlayer.getHand();
        for (int i = 0; i < hand.size(); i++) {
            Tile tile = hand.get(i);
            if (tile.isEqualToString(suit, num)) {
                return tile;
            }
        }
        return null;
    }

    public void printCurrentPlayerHand() {
        Player currentPlayer = this.mahjongBoard.getSeatPositions()[this.currentPlayerPosition];
        System.out.println(currentPlayer.getHand());
    }
    public void printCurrentPlayerDiscard() {
        Player currentPlayer = this.mahjongBoard.getSeatPositions()[this.currentPlayerPosition];
        System.out.println(currentPlayer.getDiscard());
    }

    public void printCurrentPlayerSeat() {
        Player currentPlayer = this.mahjongBoard.getSeatPositions()[this.currentPlayerPosition];
        System.out.println(this.mahjongBoard.getPlayerSeat(currentPlayer));
    }
}

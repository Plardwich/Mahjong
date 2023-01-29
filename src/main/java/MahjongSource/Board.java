package MahjongSource;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter
public class Board {
    private List<Tile> allTiles;
    private Queue<Tile> wall;

    //Will implement this deadwall stuff later
    //private Queue<Tile> deadWall;

    private Player[] seatPositions;

    private static Rules rules = new Rules();

    public Board() {
        this.allTiles = new ArrayList<>();
        addAllTiles();
        Collections.shuffle(this.allTiles);
        this.wall = new LinkedList<>(this.allTiles);
        placePlayers();
        /*
        *****Will implement this dead wall stuff later*****
        for (int i = 0; i < 14; i++) {
            this.deadWall.add(this.wall.poll());
        }
         */
    }

    public int getPlayerSeatIndex(Player player) {
        int position = -1;
        for (int i = 0; i < this.seatPositions.length; i++) {
            if (seatPositions[i] == player) {
                position = i;
            }
        }
        return position;
    }

    public String getPlayerSeat(Player player) {
        return rules.SEAT_POSITION_ORDER[getPlayerSeatIndex(player)];
    }

    private void addAllTiles() {
        addSuitOfTiles("man");
        addSuitOfTiles("pin");
        addSuitOfTiles("sou");
        addHonors();
    }

    private void addFourTiles(Tile tile) {
        this.allTiles.add(tile);
        for (int i = 0; i < 3; i++) {
            this.allTiles.add(tile.copy());
        }
    }

    private void addSuitOfTiles(String suit) {
        for (int i = 1; i < 10; i++) {
            addFourTiles(new Tile(suit, i));
        }
    }

    private void addHonors() {
        addWind();
        addDragon();
    }

    private void addWind() {
        addFourTiles(new Tile("Ton", 0));
        addFourTiles(new Tile("Nan", 0));
        addFourTiles(new Tile("Shaa", 0));
        addFourTiles(new Tile("Pei", 0));
    }

    private void addDragon() {
        addFourTiles(new Tile("Haku", 0));
        addFourTiles(new Tile("Hatsu", 0));
        addFourTiles(new Tile("Chun", 0));
    }

    private void placePlayers() {
        this.seatPositions = new Player[4];
        for (int i = 0; i < this.seatPositions.length; i++) {
            this.seatPositions[i] = new Player();
        }
    }
}

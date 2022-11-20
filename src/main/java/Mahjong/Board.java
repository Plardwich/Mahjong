package Mahjong;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter
public class Board {
    private List<Tile> allTiles;
    private Queue<Tile> wall;

    private Player playerEast;
    private Player playerNorth;
    private Player playerSouth;
    private Player playerWest;

    public Board() {
        addAllTiles();
        Collections.shuffle(this.allTiles);
        this.wall = new LinkedList<>(this.allTiles);
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
}

package MahjongSource;

import java.util.ArrayList;
import java.util.List;

public class HandBlock {
    private List<Tile> tiles;
    private String type;

    public HandBlock(List<Tile> tiles, String type) {
        this.tiles = tiles;
        this.type = type;
    }

    public HandBlock() {
        this(new ArrayList<Tile>(), "");
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public String toString() {
        String result = "{" + tiles.get(0).toString();
        for (int i = 1; i < tiles.size(); i++) {
            result += " " + tiles.get(i).toString();
        }
        return result + "}";
    }

    public void add(Tile tile) {
        this.tiles.add(tile);
    }

    public void remove(Tile tile) {
        this.tiles.remove(tile);
    }

    public boolean isDragon() {
        return isTripleOrKan() && this.tiles.get(0).getSuit().equals("dragon");
    }

    public boolean isScoringWind() {
        return isTripleOrKan() && this.tiles.get(0).getSuit().equals("wind"); //add logic to make sure that the wind is also scoring
    }

    public boolean isValid() {
        return isDouble() || isTriple() || isKan() || isSequence();
    }

    public boolean isDouble() {
        return this.tiles.size() == 2 && isAllSameNum();
    }

    public boolean isTriple() {
        return this.tiles.size() == 3 && isAllSameNum();
    }

    public boolean isKan() {
        return this.tiles.size() == 4 && isAllSameNum();
    }

    public boolean isSequence() {
        if (this.tiles.size() != 3) {
            return false;
        }
        int firstNum = this.tiles.get(0).getNum();
        int secondNum = this.tiles.get(1).getNum();
        int thirdNum = this.tiles.get(2).getNum();
        return firstNum == secondNum - 1 && secondNum == thirdNum - 1 && isSameSuit();
    }

    public HandBlock copy() {
        return new HandBlock(new ArrayList<Tile>(this.tiles), this.type);
    }

    public void clear() {
        this.tiles.clear();
        this.type = "";
    }

    private boolean isAllSameNum() {
        int preNum = this.tiles.get(0).getNum();
        for (int i = 1; i < this.tiles.size(); i++) {
            int num = this.tiles.get(i).getNum();
            if (preNum != num) {
                return false;
            }
        }
        return isSameSuit();
    }

    private boolean isSameSuit() {
        String firstTileSuit = this.tiles.get(0).getSuit();
        String secondTileSuit = this.tiles.get(1).getSuit();
        return firstTileSuit.equals(secondTileSuit);
    }

    private boolean isTripleOrKan() {
        return this.type.equals("triple") || this.type.equals("kan");
    }
}

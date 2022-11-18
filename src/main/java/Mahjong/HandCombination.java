package Mahjong;

import java.util.List;

public class HandCombination implements Comparable<HandCombination> {
    private List<HandBlock> blocks;
    private List<Tile> tiles;


    public HandCombination(List<HandBlock> blocks, List<Tile> tiles) {
        this.blocks = blocks;
        this.tiles = tiles;
    }

    public HandCombination(List<HandBlock> blocks) {
        this(blocks, null);
    }

    public String toString() {
        String result = "  ----{";
        for (HandBlock block : blocks) {
            List<Tile> listOfTiles = block.getTiles();
            result += " {";
            for (int i = 0; i < listOfTiles.size(); i++) {
                result += listOfTiles.get(i).toString() + ", ";
            }
            result += "} ";
        }
        return result + "}----  ";
    }

    public int compareTo(HandCombination combo) {
        if (combo.blocks.size() > this.blocks.size()) {
            return 1;
        }
        if (combo.blocks.size() < this.blocks.size()) {
            return -1;
        }
        return 0;
    }
}

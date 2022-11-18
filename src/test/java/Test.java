import Mahjong.Player;
import Mahjong.Tile;

import java.util.ArrayList;
import java.util.List;


public class Test {

    public static void main(String[]  args) {
        List<Tile> tiles = new ArrayList<>();
        List<Tile> block = new ArrayList<>();
        tiles.add(new Tile("red", 2));
        tiles.add(new Tile("red", 3));
        tiles.add(new Tile("red", 4));
        tiles.add(new Tile("red", 4));
        tiles.add(new Tile("red", 4));
        tiles.add(new Tile("green", 3));
        tiles.add(new Tile("green", 4));
        tiles.add(new Tile("green", 5));
        tiles.add(new Tile("blue", 7));
        tiles.add(new Tile("blue", 8));
        tiles.add(new Tile("blue", 9));
        tiles.add(new Tile("blue", 2));
        tiles.add(new Tile("blue", 3));
        tiles.add(new Tile("blue", 4));
        Player jason  = new Player(tiles);
        jason.findHandCombinations();
        jason.getHandCombinations().sort(null);
        System.out.println(jason.getHandCombinations().toString());
    }
}

package MahjongSource;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Getter
public class Player {
    private List<Tile> hand;

    private List<Tile> discard;
    private List<HandCombination> handCombinations;

    public Player(List<Tile> hand) {
        this.hand = hand;
        this.handCombinations = new ArrayList<HandCombination>();
        this.discard = new ArrayList<>();
    }

    public Player() {
        this(new ArrayList<Tile>());
    }

    public void discardTile(Tile tile) {
        if (!this.hand.contains(tile)) {
            throw new IllegalArgumentException();
        }
        this.discard.add(tile);
        this.hand.remove(tile);
    }

    public void draw(Tile tile) {
        hand.add(tile);
    }

    public void findHandCombinations() {
        this.handCombinations.clear();
        HandBlock block = new HandBlock();
        Stack<HandBlock> blocks = new Stack<>();
        Stack<Tile> remainder = new Stack<>();
        findHandCombinations(this.hand, block, blocks, remainder, 0);
    }

    private void findHandCombinations(List<Tile> allTiles, HandBlock block, Stack<HandBlock> blocks, Stack<Tile> remainder, int index) {
        if (index == allTiles.size()) {
            this.handCombinations.add(new HandCombination(new ArrayList<>(blocks), remainder));
        } else {
            Tile currTile = allTiles.get(index);
            checkSequence(allTiles, block, blocks, remainder, index);
            checkDouble(allTiles, block, blocks, remainder, index);
            checkTriple(allTiles, block, blocks, remainder, index);
            checkKan(allTiles, block, blocks, remainder, index);
            remainder.push(currTile);
            findHandCombinations(allTiles, block, blocks, remainder, index + 1);
            remainder.pop();
        }
    }

    private void checkSequence(List<Tile> allTiles, HandBlock block, Stack<HandBlock> blocks, Stack<Tile> remainder, int index) {
        if (allTiles.size() > index + 2) {
            for (int i = 0; i < 3; i++) {
                block.add(allTiles.get(index + i));
            }
            if (block.isSequence()) {
                blocks.push(block.copy());
                block.clear();
                findHandCombinations(allTiles, block, blocks, remainder, index + 3);
                blocks.pop();
            } else {
                block.clear();
            }

        }
    }

    private void checkDouble(List<Tile> allTiles, HandBlock block, Stack<HandBlock> blocks, Stack<Tile> remainder, int index) {
        if (allTiles.size() > index + 1) {
            for (int i = 0; i < 2; i++) {
                block.add(allTiles.get(index + i));
            }
            if (block.isDouble()) {
                blocks.push(block.copy());
                block.clear();
                findHandCombinations(allTiles, block, blocks, remainder, index + 2);
                blocks.pop();
            } else {
                block.clear();
            }
        }
    }

    private void checkTriple(List<Tile> allTiles, HandBlock block, Stack<HandBlock> blocks, Stack<Tile> remainder, int index) {
        if (allTiles.size() > index + 2) {
            for (int i = 0; i < 3; i++) {
                block.add(allTiles.get(index + i));
            }
            if (block.isTriple()) {
                blocks.push(block.copy());
                block.clear();
                findHandCombinations(allTiles, block, blocks, remainder, index + 3);
                blocks.pop();
            } else {
                block.clear();
            }
        }
    }

    private void checkKan(List<Tile> allTiles, HandBlock block, Stack<HandBlock> blocks, Stack<Tile> remainder, int index) {
        if (allTiles.size() > index + 3) {
            for (int i = 0; i < 4; i++) {
                block.add(allTiles.get(index + i));
            }
            if (block.isKan()) {
                blocks.push(block.copy());
                block.clear();
                findHandCombinations(allTiles, block, blocks, remainder, index + 4);
                blocks.pop();
            } else {
                block.clear();
            }
        }
    }
}

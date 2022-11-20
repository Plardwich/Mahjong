package Mahjong;

public class Tile {
    private boolean isDora;
    private boolean isConcealed;
    private String suit;
    private int num;

    public Tile(String suit, int num, boolean isDora, boolean isConcealed) {
        this.suit = suit;
        this.num = num;
        this.isDora = isDora;
        this.isConcealed = isConcealed;
    }

    public Tile(String suit, int num, boolean isDora) {
        this(suit, num, isDora, true);
    }

    public Tile(String suit, int num) {
        this(suit, num, false, true);
    }

    public Tile(String suit) {
        this(suit, -1, false, true);
    }

    public String getSuit() {
        return this.suit;
    }

    public int getNum() {
        return this.num;
    }

    public String toString() {
        return "(" + suit + ", " + num + ")";
    }

    public void reveal() {
        this.isConcealed = false;
    }

    public void makeDora() {
        this.isDora = true;
    }

    public Tile copy() {
        return new Tile(this.suit, this.num, this.isDora, this.isConcealed);
    }
}

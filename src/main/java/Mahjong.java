import MahjongSource.*;
import java.util.*;

public class Mahjong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController ref = new GameController();
        ref.startingDeal();
        for (int i = 0; i < 10; i++) {
            turn(ref, scanner);
            ref.nextTurn();
        }
    }

    public static void turn(GameController ref, Scanner scanner) {
        System.out.println("---------------------");
        ref.printCurrentPlayerSeat();
        System.out.println();
        ref.deal();
        ref.printCurrentPlayerHand();
        System.out.println();
        System.out.print("What suit of tile would you like to discard? ");
        String tileSuit = scanner.nextLine();
        System.out.print("What number tile would you like to discard? ");
        String tileNum = scanner.nextLine();
        Tile tileSelected = ref.checkForMatchingTile(tileSuit, tileNum);
        ref.discard(tileSelected);
        ref.printCurrentPlayerHand();
        System.out.println();
        ref.printCurrentPlayerDiscard();
        System.out.println();
    }
}

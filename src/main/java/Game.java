import model.*;
import controller.Input;
import view.Screen;

import java.util.Set;

public class Game {
    public static void main(String[] args) {

        //start();
        game();
    }





    public static void start() {

        final String ANSI_GREEN = "\u001B[32m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println();
        System.out.println(ANSI_YELLOW + "                                                                                              WELCOME TO CHESS !" + ANSI_RESET);
        System.out.println();

        // WE ASK THE USER IF HE WANTS TO PLAY OR NOT (IF HE DECIDED PLAY, THE GAME STARTED)
        int answer = Input.getIntDown("1 - PLAY  /  2 - EXIT");

        while (answer < 1 || answer > 2) {
            System.err.println("ERROR, WRITE A CORRECT NUMBER !!");
            answer = Input.getIntDown(" 1 - PLAY  /  2 - EXIT");
        }

        if (answer == 1) {

            System.out.println();
            System.out.println(ANSI_YELLOW + "                                                  ************************************          INSTRUCTIONS          *************************************" + ANSI_RESET);
            System.out.println();
            System.out.println("                                                  1 - Multiplayer game. One player plays with the white pieces and the other player with the black pieces.");
            System.out.println("                                                  2 - The white (or lighter) pieces always start to move first.");
            System.out.println("                                                  3 - Each player has sixteen pieces at the start of the game: one king, one queen, two rooks, two bishops, " + "\n                                                      two knights and eight pawns.");
            System.out.println("                                                  4 - Each type of piece has a different and determined movement.");
            System.out.println("                                                  5 - The game is won by the player who kills the rival king and 'kills' it.");
            System.out.println();
            System.out.println(ANSI_YELLOW + "                                                  *********************************************************************************************************" + ANSI_RESET);
            System.out.println();

        } else {

            System.out.println();
            System.out.println(ANSI_YELLOW + "                                                                                   WE ARE WAITING FOR YOU AT ANOTHER TIME !" + ANSI_RESET);

        }
    }



    public static void game() {

        //String playerOne = Input.getString("Name for player #1 (WHITE): ");
        //String playerTwo = Input.getString("Name for player #2 (BLACK): ");
        System.out.println();

        Board b = new Board();
        b.placePieces();


        Set<Coordinate> coordinates;

        coordinates = b.getCell(new Coordinate('B', 1)).getPiece().getNextMovements();
        b.highlight(coordinates);
        Screen.showBoard(b);

        coordinates = b.getCell(new Coordinate('A', 2)).getPiece().getNextMovements();
        b.highlight(coordinates);
        Screen.showBoard(b);
    }
}

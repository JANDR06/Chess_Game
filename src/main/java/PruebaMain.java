import model.*;
import controller.Input;
import view.Screen;

public class PruebaMain {
    public static void main (String[] args) {



        game();
    }

    public static void game () {

        final String ANSI_GREEN = "\u001B[32m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println();
        System.out.println(ANSI_GREEN + "WELCOME TO CHESS !" + ANSI_RESET);
        System.out.println();
        int answer = Input.getIntDown("1 - PLAY  /  2 - EXIT");

        // WE ASK THE USER IF HE WANTS TO PLAY OR NOT (IF HE DECIDED YES, THE GAME STARTED)

        while (answer < 1 || answer > 2) {
            System.err.println("¡¡ ERROR, WRITE A CORRECT NUMBER !!");
            answer = Input.getIntDown(" 1 - PLAY  /  2 - EXIT");
        }

        if (answer == 1) {

            System.out.println();
            System.out.println(ANSI_GREEN + "************************************          INSTRUCTIONS          **************************************" + ANSI_RESET);
            System.out.println();
            System.out.println("1 - Multiplayer game. One player plays with the white pieces and the other player with the black pieces.");
            System.out.println("2 - The white (or lighter) pieces always start to move first.");
            System.out.println("3 - Each player has sixteen pieces at the start of the game: one king, one queen, two rooks, two bishops, " + "\n    two knights and eight pawns.");
            System.out.println("4 - Each type of piece has a different and determined movement.");
            System.out.println("5 - The game is won by the player who kills the rival king and 'kills' it.");

            System.out.println();
            System.out.println(ANSI_GREEN + "**********************************************************************************************************" + ANSI_RESET);
            System.out.println();

            Board b = new Board();
            b.placePieces();

            String playerOne = Input.getString("Name for player #1 (WHITE): ");
            String playerTwo = Input.getString("Name for player #2 (BLACK): ");
            System.out.println();

            while () {

            }

            Screen.showBoard(b);


        } else {

            System.out.println();
            System.out.println(ANSI_GREEN + "WE ARE WAITING FOR YOU AT ANOTHER TIME !" + ANSI_RESET);

        }


    }
}

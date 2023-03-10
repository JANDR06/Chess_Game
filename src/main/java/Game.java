import model.*;
import controller.Input;
import view.Screen;

import java.sql.SQLOutput;
import java.util.Set;

public class Game {
    public static void main(String[] args) {

        start();
        game();
    }





    public static void start() {

        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println();
        System.out.println(ANSI_YELLOW + "                                                                      WELCOME TO CHESS !" + ANSI_RESET);
        System.out.println();

        // WE ASK THE USER IF HE WANTS TO PLAY OR NOT (IF HE DECIDED PLAY, THE GAME STARTED)
        int answer = Input.getInt("                                                       SELECT WHAT YOU WANT TO DO (1 - PLAY  /  2 - EXIT): ");

        while (answer < 1 || answer > 2) {
            System.err.println("                                                       ERROR, WRITE A CORRECT NUMBER !!");
            answer = Input.getInt("                                                       SELECT WHAT YOU WANT TO DO (1 - PLAY  /  2 - EXIT): ");
        }

        if (answer == 1) {

            System.out.println();
            System.out.println(ANSI_YELLOW + "                           ************************************          INSTRUCTIONS          *************************************" + ANSI_RESET);
            System.out.println();
            System.out.println("                           1 - Multiplayer game. One player plays with the white pieces and the other player with the black pieces.");
            System.out.println("                           2 - The white (or lighter) pieces always start to move first.");
            System.out.println("                           3 - Each player has sixteen pieces at the start of the game: one king, one queen, two rooks, two bishops, " + "\n                                                      two knights and eight pawns.");
            System.out.println("                           4 - Each type of piece has a different and determined movement.");
            System.out.println("                           5 - The game is won by the player who kills the rival king and 'kills' it.");
            System.out.println();
            System.out.println(ANSI_YELLOW + "                           *********************************************************************************************************" + ANSI_RESET);
            System.out.println();

        } else {

            System.out.println();
            System.out.println(ANSI_YELLOW + "                                                              WE ARE WAITING FOR YOU AT ANOTHER TIME !" + ANSI_RESET);

        }
    }



    public static void game() {

        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";

        String playerOne = Input.getString("                           Name for player #1 (WHITE): ");
        String playerTwo = Input.getString("                           Name for player #2 (BLACK): ");
        System.out.println();

        Board b = new Board();
        b.placePieces();
        Screen.showBoard(b);


        // START COORDINATE
        System.out.println();
        System.out.println(ANSI_YELLOW + "                           Move " + playerOne + " -> WHITE" + ANSI_RESET);
        System.out.println("                           Wich piece do you want to move?");
        String firstCoordinate = Input.getString("                           Enter a coordinate: ");

        // WE CHECK IF THE COORDINATE HAS LENGTH = 2 (EX: B5)
        while (firstCoordinate.length() != 2) {
            System.err.println("                           COORDINATE ERROR !");
            firstCoordinate = Input.getString("                           Enter a coordinate: ");
        }

        char column = firstCoordinate.charAt(0);
        int row = (int) firstCoordinate.charAt(1) - 48;



        // CHECK IF THERE IS A PIECE IN THE SELECTED COORDINATE OR NOT
        while (! b.getCell(new Coordinate(column, row)).containsPiece()) {
            System.err.println("                           COORDINATE ERROR !");
            firstCoordinate = Input.getString("                           Enter a coordinate: ");

            while (firstCoordinate.length() != 2) {
                System.err.println("                           COORDINATE ERROR !");
                firstCoordinate = Input.getString("                           Enter a coordinate: ");

            }

            column = firstCoordinate.charAt(0);
            row = (int) firstCoordinate.charAt(1) - 48;
        }



        // WE CHECK THAT THE COORDINATE DATA IS VALID
        while (column != 'A' && column != 'B' && column != 'C' && column != 'D' && column != 'E' && column != 'F' && column != 'G' && column != 'H' || row < 1 || row > 8) {
            System.err.println("                           COORDINATE ERROR !");
            firstCoordinate = Input.getString("                           Enter a coordinate: ");


            while (firstCoordinate.length() != 2) {
                System.err.println("                           COORDINATE ERROR !");
                firstCoordinate = Input.getString("                           Enter a coordinate: ");

            }

            column = firstCoordinate.charAt(0);
            row = (int) firstCoordinate.charAt(1) - 48;

        }

        Set<Coordinate> coordinates;
        coordinates = b.getCell(new Coordinate(column, row)).getPiece().getNextMovements();
        b.highlight(coordinates);
        Screen.showBoard(b);





        // DESTINATION COORDINATE
        System.out.println(ANSI_YELLOW + "                           Where do you want to move it?" + ANSI_RESET);
        String secondCoordinate = Input.getString("                           Enter a coordinate: ");

        // WE CHECK IF THE COORDINATE HAS LENGTH = 2 (EX: B5)
        while (secondCoordinate.length() != 2) {
            System.err.println("                           COORDINATE ERROR !");
            secondCoordinate = Input.getString("                           Enter a coordinate: ");
        }

        char columnTwo = secondCoordinate.charAt(0);
        int rowTwo = (int) secondCoordinate.charAt(1) - 48;

        // WE CHECK THAT THE COORDINATE DATA IS VALID
        while (columnTwo != 'A' && columnTwo != 'B' && columnTwo != 'C' && columnTwo != 'D' && columnTwo != 'E' && columnTwo != 'F' && columnTwo != 'G' && columnTwo != 'H' || rowTwo < 1 || rowTwo > 8) {
            System.err.println("                           COORDINATE ERROR !");
            secondCoordinate = Input.getString("                           Enter a coordinate: ");


            while (secondCoordinate.length() != 2) {
                System.err.println("                           COORDINATE ERROR !");
                secondCoordinate = Input.getString("                           Enter a coordinate: ");

            }

            columnTwo = secondCoordinate.charAt(0);
            rowTwo = (int) secondCoordinate.charAt(1) - 48;

        }

        b.getCell (new Coordinate(column, row)).getPiece().moveTo(new Coordinate(columnTwo, rowTwo));
        b.resetColors();
        Screen.showBoard(b);

    }
}
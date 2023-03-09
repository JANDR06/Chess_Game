package view;

import model.Board;
import model.Coordinate;

public class Screen {

    // METHOD TO SHOW THE FIRST AND LAST ROW OF THE BOARD
    private static String getLetters () {
        return "                                                                     A  B  C  D  E  F  G  H\n";
    }

    // METHOD TO SHOW THE INTERMEDIATE ROWS OF THE BOARD
    private static String getMiddleRows (Board board, int row) {
        StringBuilder exit = new StringBuilder("                                                                  " + row + " ");

        for (int column = 0; column < 8; column++) {
            exit.append(board.getCell(new Coordinate((char) ('A' + column), row)));
        }

        return exit.append("" + row + "\n").toString();
    }

    // METHOD TO SHOW THE BOARD
    public static void showBoard (Board board) {
        StringBuilder exit = new StringBuilder();
        exit.append(getLetters());

        for (int row = 1; row < 9; row++) {
            exit.append(getMiddleRows(board, row));
        }

        exit.append(getLetters());
        System.out.println(exit);
    }
}

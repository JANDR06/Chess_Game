package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board {

    // BOARD CLASS ATTRIBUTES
    private final Map<Coordinate, Cell> cells;

    // BUILDER
    public Board () {
        cells = new HashMap<>();
        initializeCells();
    }

    // METHOD TO INITIALIZE THE CELLS
    private void initializeCells () {
        Coordinate coordinate;
        Cell cell;

        for (int row = 0; row < 8; row++) {

            for (int column = 0; column < 8; column++) {
                coordinate = new Coordinate((char) ('A' + column), 1 + row);
                cell = new Cell(this, coordinate);

                cells.put(coordinate, cell);
            }
        }
    }

    // METHOD THAT HIGHLIGHTS THE CELLS WITH THE POSSIBLE FOLLOWING MOVEMENTS
    public void highlight (Set<Coordinate> coordinates) {

        for (Coordinate c : coordinates) {
            cells.get(c).highlight();
        }
    }

    // METHOD TO REMOVE THE HIGHLIGHT FROM THE CELL
    public void resetColors() {

        for (Coordinate c : cells.keySet()) {
            cells.get(c).resetColor();
        }
    }

    // METHOD FOR PLACING THE PIECES
    public void placePieces() {
        Piece p;

        // PLACE KNIGHTS
        p = new KnightWhite(getCell(new Coordinate('B',8)));
        p.putInYourPlace();
        p = new KnightWhite(getCell(new Coordinate('G',8)));
        p.putInYourPlace();

        p = new KnightBlack(getCell(new Coordinate('B',1)));
        p.putInYourPlace();
        p = new KnightBlack(getCell(new Coordinate('G',1)));
        p.putInYourPlace();

        // PLACE BISHOPS
        p = new BishopWhite(getCell(new Coordinate('C',8)));
        p.putInYourPlace();
        p = new BishopWhite(getCell(new Coordinate('F',8)));
        p.putInYourPlace();

        p = new BishopBlack(getCell(new Coordinate('C',1)));
        p.putInYourPlace();
        p = new BishopBlack(getCell(new Coordinate('F',1)));
        p.putInYourPlace();

        // PLACE KINGS
        p = new KingWhite(getCell(new Coordinate('D',8)));
        p.putInYourPlace();

        p = new KingBlack(getCell(new Coordinate('D',1)));
        p.putInYourPlace();

        // PLACE ROOKS
        p = new RookWhite(getCell(new Coordinate('A',8)));
        p.putInYourPlace();
        p = new RookWhite(getCell(new Coordinate('H',8)));
        p.putInYourPlace();

        p = new RookBlack(getCell(new Coordinate('A',1)));
        p.putInYourPlace();
        p = new RookBlack(getCell(new Coordinate('H',1)));
        p.putInYourPlace();

        // PLACE QUEENS
        p = new QueenWhite(getCell(new Coordinate('E',8)));
        p.putInYourPlace();

        p = new QueenBlack(getCell(new Coordinate('E',1)));
        p.putInYourPlace();

        // PLACE PAWNS
        for (int i = 0; i < 8; i++) {
            p = new PawnBlack(getCell(new Coordinate((char)('A'+i),2)));
            p.putInYourPlace();
            p = new PawnWhite(getCell(new Coordinate((char)('A'+i),7)));
            p.putInYourPlace();
        }

    }

    // METHOD THAT RETURNS THE ASSOCIATED CELL FROM A DETERMINED COORDINATE
    public Cell getCell (Coordinate c) {
        return cells.get(c);
    }
}

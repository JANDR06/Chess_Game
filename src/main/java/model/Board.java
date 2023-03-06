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

        // PLACE KNIGHTS
        new Knight(this, new Coordinate('B', 1), Knight.KnightType.BLACK);
        new Knight(this, new Coordinate('G', 1), Knight.KnightType.BLACK);
        new Knight(this, new Coordinate('B', 8), Knight.KnightType.WHITE);
        new Knight(this, new Coordinate('G', 8), Knight.KnightType.WHITE);

        // PLACE BISHOPS
        new Bishop(this, new Coordinate('C', 1), Bishop.BishopType.BLACK);
        new Bishop(this, new Coordinate('F', 1), Bishop.BishopType.BLACK);
        new Bishop(this, new Coordinate('C', 8), Bishop.BishopType.WHITE);
        new Bishop(this, new Coordinate('F', 8), Bishop.BishopType.WHITE);

        // PLACE KINGS
        new King(this, new Coordinate('E', 1), King.KingType.BLACK);
        new King(this, new Coordinate('E', 8), King.KingType.WHITE);

        // PLACE ROOKS
        new Rook(this, new Coordinate('A', 1), Rook.RookType.BLACK);
        new Rook(this, new Coordinate('H', 1), Rook.RookType.BLACK);
        new Rook(this, new Coordinate('A', 8), Rook.RookType.WHITE);
        new Rook(this, new Coordinate('H', 8), Rook.RookType.WHITE);

        // PLACE QUEENS
        new Queen(this, new Coordinate('D', 1), Queen.QueenType.BLACK);
        new Queen(this, new Coordinate('D', 8), Queen.QueenType.WHITE);

        // PLACE PAWNS
        for (int i = 0; i < 8; i++) {
            new Pawn(this, new Coordinate((char) ('A' + i), 2), Pawn.Type.BLACK);
            new Pawn(this, new Coordinate((char) ('A' + i), 7), Pawn.Type.WHITE);
        }
    }

    // METHOD THAT RETURNS THE ASSOCIATED CELL FROM A DETERMINED COORDINATE
    public Cell getCell (Coordinate c) {
        return cells.get(c);
    }
}

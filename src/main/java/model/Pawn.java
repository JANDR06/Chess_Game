package model;

import java.util.HashSet;
import java.util.Set;

public abstract class Pawn extends Piece {

    // BUILDER
    public Pawn (Type type, Cell cell) {
        super (type, cell);
    }

    // TRANSFORM ABSTRACT METHOD
    public abstract void transform();

    // MOVE TO METHOD
    @Override
    public void moveTo (Coordinate c) {
        super.moveTo(c);
        if (getCell().getCoordinate().getRow() == 8 ||
                getCell().getCoordinate().getRow() == 1)
            transform();
    }

    // CHECK PAWN KILLER METHOD
    protected void checkPawnKiller (Coordinate c) {
        Set<Coordinate> nextMovements = new HashSet<>();
        Board board = getCell().getBoard();
        if ((board.getCell(c) != null) && (!(board.getCell(c).isEmpty())) && (board.getCell(c).getPiece().getColor() != getColor()))
            nextMovements.add(c);
    }

    // CHECK PAWN MOVE METHOD
    protected void checkPawnMove (Coordinate c) {
        Set<Coordinate> nextMovements = new HashSet<>();
        Board board = getCell().getBoard();
        if ((board.getCell(c) != null) && (board.getCell(c).isEmpty()))
            nextMovements.add(c);
    }
}
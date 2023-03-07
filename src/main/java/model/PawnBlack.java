package model;

import java.util.HashSet;
import java.util.Set;

public class PawnBlack extends Pawn {

    // BUILDER
    public PawnBlack(Cell cell) {
        super(Type.BLACK_PAWN, cell);
    }

    // GET NEXT MOVEMENTS METHOD
    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> nextMovements = new HashSet<>();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        c = position.down();
        checkPawnMove(c);
        if (getCell().getCoordinate().getRow() == 2) {
            c = position.down().down();
            checkPawnMove(c);
        }

        c = position.diagonalDownLeft();
        checkPawnKiller(c);
        c = position.diagonalDownRight();
        checkPawnKiller(c);

        return nextMovements;

    }

    // TRANSFORM METHOD
    @Override
    public void transform() {
        new QueenBlack(getCell());
        cell = null;
    }
}

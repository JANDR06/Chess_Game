package model;

import java.util.HashSet;
import java.util.Set;

public abstract class King extends Piece{

    // BUILDER
    public King(Type type, Cell cell) {
        super(type, cell);
    }

    // GET NEXT MOVEMENTS METHOD
    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> nextMovements = new HashSet<>();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        c = position.up();
        check(c, nextMovements);
        c = position.left();
        check(c, nextMovements);
        c = position.down();
        check(c, nextMovements);
        c = position.right();
        check(c, nextMovements);
        c = position.diagonalDownLeft();
        check(c, nextMovements);
        c = position.diagonalDownRight();
        check(c, nextMovements);
        c = position.diagonalUpLeft();
        check(c, nextMovements);
        c = position.diagonalUpRight();
        check(c, nextMovements);

        return nextMovements;

    }
}
package model;

import java.util.HashSet;
import java.util.Set;

public abstract class Knight extends Piece {

    // BUILDER
    public Knight(Type type, Cell cell) {
        super(type, cell);
    }

    // GET NEXT MOVEMENTS METHOD
    public Set<Coordinate> getNextMovements () {
        Set<Coordinate> nextMovements = new HashSet<>();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        // UP
        c = position.up().up().right();
        check(c, nextMovements);
        c = position.up().up().left();
        check(c, nextMovements);

        // DOWN
        c = position.down().down().left();
        check(c, nextMovements);
        c = position.down().down().right();
        check(c, nextMovements);

        // LEFT
        c = position.left().left().up();
        check(c, nextMovements);
        c = position.left().left().down();
        check(c, nextMovements);

        // RIGHT
        c = position.right().right().down();
        check(c, nextMovements);
        c = position.right().right().up();
        check(c, nextMovements);

        return nextMovements;
    }
}

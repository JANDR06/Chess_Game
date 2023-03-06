package model;

import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {

    // BUILDER
    public Knight (Board board, Coordinate position, KnightType type) {
        super (type.getType(), board.getCell(position));
    }

    // GET NEXT MOVEMENTS METHOD
    public Set<Coordinate> getNextMovements () {
        Set<Coordinate> nextMovements = new HashSet<>();
        Coordinate destination;

        // UP
        destination = getPosition().up().up().left();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        destination = getPosition().up().up().left();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        // DOWN
        destination = getPosition().up().up().left();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        destination = getPosition().up().up().left();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        // LEFT
        destination = getPosition().up().up().left();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        destination = getPosition().up().up().left();
        if (canMoveTo(destination))
            nextMovements.add(destination);

        // RIGHT
        destination = getPosition().up().up().left();
        if (canMoveTo(destination))
            nextMovements.add(destination);
        destination = getPosition().up().up().left();

        if (canMoveTo(destination))
            nextMovements.add(destination);

        return nextMovements;
    }


    // TYPE KNIGHT ENUM CLASS
    public enum KnightType {

        BLACK (Piece.Type.BLACK_KNIGHT), WHITE (Piece.Type.WHITE_KNIGHT);

        // KNIGHT TYPE CLASS ATTRIBUTES
        private Piece.Type type;

        // BUILDER
        KnightType (Piece.Type type) {
            this.type = type;
        }

        // GET
        public Piece.Type getType () {
            return type;
        }
    }
}

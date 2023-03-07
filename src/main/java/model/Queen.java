package model;

import java.util.Set;

public class Queen extends Piece {

    // BUILDER
    public Queen (Type type, Cell cell) {
        super(type, cell);
    }

    // GET NEXT MOVEMENTS METHOD
    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> nextMovements = Rook.getNextMovementsAsRook(this);
        nextMovements.addAll(Bishop.getNextMovementsAsBishop(this));

        return nextMovements;
    }


}

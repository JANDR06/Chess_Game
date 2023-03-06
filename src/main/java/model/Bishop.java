package model;

import java.util.Set;

public class Bishop extends Piece {

    // BUILDER
    public Bishop (Board board, Coordinate position, BishopType bishopType) {
        super(bishopType.getType(), board.getCell(position));
    }

    // GET NEXT MOVEMENTS METHOD
    @Override
    public Set<Coordinate> getNextMovements () {
        return null;
    }

    // TYPE BISHOP ENUM CLASS
    public enum BishopType {

        BLACK (Piece.Type.BLACK_BISHOP), WHITE (Piece.Type.WHITE_BISHOP);

        // BISHOP TYPE CLASS ATTRIBUTES
        private Piece.Type type;

        // BUILDER
        BishopType (Piece.Type type) {
            this.type = type;
        }

        // GET
        public Piece.Type getType () {
            return type;
        }
    }
}

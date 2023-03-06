package model;

import java.util.Set;

public class Rook extends Piece {

    // BUILDER
    public Rook (Board board, Coordinate position, RookType rookType) {
        super (rookType.getType(), board.getCell(position));
    }

    // GET NEXT MOVEMENTS METHOD
    @Override
    public Set<Coordinate> getNextMovements () {
        return null;
    }

    // TYPE ROOK ENUM CLASS
    public enum RookType {

        BLACK (Piece.Type.BLACK_ROOK), WHITE (Piece.Type.WHITE_ROOK);

        // ROOK TYPE CLASS ATTRIBUTES
        private Piece.Type type;

        // BUILDER
        RookType (Piece.Type type) {
            this.type = type;
        }

        // GET
        public Piece.Type getType () {
            return type;
        }
    }
}
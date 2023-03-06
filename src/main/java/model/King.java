package model;

public class King extends Piece {

    // BUILDER
    public King (Board board, Coordinate position, KingType kingType) {
        super (kingType.getType(), board.getCell(position));
    }

    // TYPE KING ENUM CLASS
    public enum KingType {

        BLACK (Piece.Type.BLACK_KING), WHITE (Piece.Type.WHITE_KING);

        // KING TYPE CLASS ATTRIBUTES
        private Piece.Type type;

        // BUILDER
        KingType (Piece.Type type) {
            this.type = type;
        }

        // GET
        public Piece.Type getType () {
            return type;
        }
    }
}


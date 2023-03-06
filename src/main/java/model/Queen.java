package model;

public class Queen extends Piece {

    // BUILDER
    public Queen (Board board, Coordinate position, QueenType queenType) {
        super (queenType.getType(), board.getCell(position));
    }

    // TYPE QUEEN ENUM CLASS
    public enum QueenType {

        BLACK (Piece.Type.BLACK_QUEEN), WHITE (Piece.Type.WHITE_QUEEN);

        // QUEEN TYPE CLASS ATTRIBUTES
        private Piece.Type type;

        // BUILDER
        QueenType (Piece.Type type) {
            this.type = type;
        }

        // GET
        public Piece.Type getType () {
            return type;
        }
    }
}

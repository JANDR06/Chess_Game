package model;

import java.util.Set;

public abstract class Pawn extends Piece {

    // BUILDER
    public Pawn (Board board, Coordinate position, Type pawnType) {
        super (pawnType.getType(), board.getCell(position));
    }

    // SET OF COORDINATES
    @Override
    public Set<Coordinate> getNextMovements () {
        return null;
    }

    // MOVE TO METHOD
    @Override
    public boolean moveTo (Cell destination) {
        boolean moved = super.moveTo(destination);

        if (moved)
            if (cell.getCoordinate().getRow() == 1 &&
                    chessType.getColor() == Color.WHITE ||
                    cell.getCoordinate().getRow() == 8 &&
                            chessType.getColor() == Color.BLACK)
                createQueen();
        return moved;
    }

    // CREATE QUEEN ABSTRACT METHOD
    protected abstract void createQueen();

    // GET PAWN ENUM CLASS
    public enum Type {

        BLACK (Piece.Type.BLACK_PAWN), WHITE (Piece.Type.WHITE_PAWN);

        // PAWN CLASS ATTRIBUTES
        private Piece.Type type;

        // BUILDER
        Type (Piece.Type type) {
            this.type = type;
        }

        // GET
        public Piece.Type getType () {
            return type;
        }
    }
}
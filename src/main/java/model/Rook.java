package model;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {

    // BUILDER
    public Rook (Board board, Coordinate position, RookType rookType) {
        super (rookType.getType(), board.getCell(position));
    }

    // GET MOVEMENTS AS ROOK STATIC METHOD
    public static Set<Coordinate> getMovementsAsRook (Piece piece) {

        Set<Coordinate> nextMovements = new HashSet<>();
        Board board = piece.getPosition().getBoard();
        Coordinate destination ;

        // UP
        destination = piece.getPosition().up();

        while (board.getCell(destination) != null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.up();
        }

        if (piece.canMoveTo(destination))
            nextMovements.add(destination);

        // DOWN
        destination = piece.getPosition().down();

        while (board.getCell(destination) != null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.down();
        }

        if (piece.canMoveTo(destination))
            nextMovements.add(destination);

        // LEFT
        destination = piece.getPosition().left();

        while (board.getCell(destination) != null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.left();
        }

        if (piece.canMoveTo(destination))
            nextMovements.add(destination);

        // RIGHT
        destination = piece.getPosition().right();

        while(board.getCell(destination)!= null && board.getCell(destination).isEmpty()) {
            nextMovements.add(destination);
            destination = destination.right();
        }

        if (piece.canMoveTo(destination))
            nextMovements.add(destination);

        return nextMovements;
    }

    // GET NEXT MOVEMENTS METHOD
   @Override
   public Set<Coordinate> getNextMovements () {
        return getMovementsAsRook (this);
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
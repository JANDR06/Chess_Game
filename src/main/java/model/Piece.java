package model;

import com.diogonunes.jcolor.Attribute;
import java.util.Set;
import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {

    // PIECE CLASS ATTRIBUTES
    protected Set<Coordinate> candidatePositions;
    private Type type;
    protected Cell cell;

    // BUILDER
    public Piece (Type type, Cell cell) {
        this.cell = cell;
        this.type = type;
        placePiece();
    }

    // METHOD FOR PLACING A PIECE ON THE BOARD
    private void placePiece () {
        cell.setPiece(this);
    }

    // METHOD TO REMOVE PIECES ON THE BOARD
    protected void removePiece () {
        cell.setPiece (null);
        cell = null;
    }

    // GETTERS
    public Coordinate getPosition () { return cell.getCoordinate(); }
    public Color getColor () { return type.getColor(); }
    public Type getType () { return type; }

    // GET NEXT MOVEMENTS ABSTRACT METHOD
    public abstract Set<Coordinate> getNextMovements();

    // METHOD FOR MOVING THE PIECE AROUND THE BOARD
    public boolean moveTo (Cell destination) {

        if (!getNextMovements().contains(destination.getCoordinate()) || cell == null) {
            return false;
        }

        if (destination.containsPiece()) {
            destination.getPiece().removePiece();
        }

        cell.setPiece(null);
        cell = destination;
        placePiece();
        return true;
    }

    // TO STRING METHOD
    public String toString () {
        Attribute pieceColor = type.getColor().getAttribute();
        Attribute backColor = cell.getCellColor().getAttribute();

        return colorize (type.getShape(), pieceColor, backColor);
    }

    // METHOD TO CHECK WHETHER A PART CAN MOVE OR NOT
    protected boolean canMoveTo (Coordinate destination) {
        Cell cell = this.cell.getBoard().getCell(destination);

        // FIRST
        if (cell == null) {
            return false;
        }

        // SECOND
        if (cell.isEmpty()) {
            return true;
        }

        // THIRD
        if (cell.getPiece().getColor() != getColor()) {
            return true;
        }

        return false;
    }

    // COLOR ENUM CLASS
    public enum Color {
        WHITE (Attribute.TEXT_COLOR(255)),
        BLACK (Attribute.TEXT_COLOR(16));

        // COLOR CLASS ATTRIBUTES
        private final Attribute attribute;

        // BUILDER
        Color(Attribute attribute){
            this.attribute = attribute;
        }

        // GET
        public Attribute getAttribute () { return attribute;}

        public Color next(){
            if(this.equals(WHITE))
                return BLACK;
            return WHITE;
        }
    }

    public enum Type {
        WHITE_KING ("\u265A", Color.WHITE),
        BLACK_KING ("\u265A", Color.BLACK),
        WHITE_QUEEN ("\u265B", Color.WHITE),
        BLACK_QUEEN ("\u265B", Color.BLACK),
        WHITE_ROOK ("\u265C", Color.WHITE),
        BLACK_ROOK ("\u265C", Color.BLACK),
        WHITE_BISHOP ("\u265D", Color.WHITE),
        BLACK_BISHOP ("\u265D", Color.BLACK),
        WHITE_KNIGHT ("\u265E", Color.WHITE),
        BLACK_KNIGHT ("\u265E", Color.BLACK),
        WHITE_PAWN ("\u2659", Color.WHITE),
        BLACK_PAWN ("\u2659", Color.BLACK);

        // TYPE CLASS ATTRIBUTES
        private final String shape;
        private final Color color;

        // BUILDER
        Type (String shape, Color color) {
            this.color = color;
            this.shape = shape;
        }

        // GETTERS
        public Color getColor() {
            return color;
        }
        public String getShape() {
            return shape;
        }

        @Override
        public String toString() {
            return String.valueOf(shape);
        }

    }


}

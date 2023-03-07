package model;

import com.diogonunes.jcolor.Attribute;
import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {

    // PIECE CLASS ATTRIBUTES
    protected Set<Coordinate> candidadtePositions;
    private Type type;
    protected Cell cell;

    // BUILDER
    public Piece (Type type, Cell cell) {
        this.cell = cell;
        this.type = type;
    }

    // GETTERS
    public Cell getCell() { return cell; }
    public Color getColor() { return type.color; }
    public Type getType() { return type;}

    // PUT IN YOUR PLACE METHOD
    public void putInYourPlace(){
        cell.setPiece(this);
    }

    // ABSTRACT METHOD
    public abstract Set<Coordinate> getNextMovements();

    // CHECK METHOD
    protected void check (Coordinate coordinate, Set<Coordinate> candidadtePositions) {
        Board board = getCell().getBoard();

        if (board.getCell(coordinate) != null)
            if (board.getCell(coordinate).isEmpty() ||
                    board.getCell(coordinate).getPiece().getColor() != getColor())
                candidadtePositions.add(coordinate);
    }

    // MOVE TO METHOD
    public void moveTo (Coordinate c) {
        Board board = getCell().getBoard();

        if(board.getCell(c) != null) {
            getCell().setPiece(null);
            Cell cell = board.getCell(c);
            cell.setPiece(this);
            this.cell = cell;
        }
    }

    // TO STRING METHOD
    @Override
    public String toString() {
        return colorize(type.toString(),type.color.getPieceColor(),cell.getCellColor().getAttribute());
    }

    // ENUM CLASS COLOR
    public enum Color {
        WHITE(Attribute.TEXT_COLOR(255)),
        BLACK(Attribute.TEXT_COLOR(16));

        // COLOR ENUM CLASS ATTRIBUTES
        private final Attribute pieceColor;

        // BUILDER
        private Color(Attribute pieceColor){
            this.pieceColor = pieceColor;
        }

        // GET
        public Attribute getPieceColor() { return pieceColor; }

        // NEXT METHOD
        public Color next(){
            if(this.equals(WHITE))
                return BLACK;
            return WHITE;
        }
    }

    // ENUM CLASS TYPE
    public enum Type {
        WHITE_KING("\u265A", Color.WHITE),
        BLACK_KING("\u265A", Color.BLACK),
        WHITE_QUEEN("\u265B", Color.WHITE),
        BLACK_QUEEN("\u265B", Color.BLACK),
        WHITE_ROOK("\u265C", Color.WHITE),
        BLACK_ROOK("\u265C", Color.BLACK),
        WHITE_BISHOP("\u265D", Color.WHITE),
        BLACK_BISHOP("\u265D", Color.BLACK),
        WHITE_KNIGHT("\u265E", Color.WHITE),
        BLACK_KNIGHT("\u265E", Color.BLACK),
        WHITE_PAWN("\u2659", Color.WHITE),
        BLACK_PAWN("\u2659", Color.BLACK);

        // TYPE ENUM CLASS ATTRIBUTES
        private String shape;
        private Color color;

        // BUILDER
        private Type (String shape, Color color) {
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

        // TO STRING METHOD
        @Override
        public String toString() {
            return String.valueOf(shape);
        }

    }
}
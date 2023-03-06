package model;

import com.diogonunes.jcolor.Attribute;
import static com.diogonunes.jcolor.Ansi.colorize;

public class Cell {

    // CELL CLASS ATTRIBUTES
    private Piece piece;
    private Board board;
    private Coordinate coordinate;
    private final Color original;
    private Color color;

    // BUILDER
    public Cell (Board board, Coordinate coordinate) {
        this.board = board;
        this.coordinate = coordinate;
        this.piece = null;

        this.original = ((coordinate.getRow() - 1 + coordinate.getColumn() - 'A') % 2 == 0)
                ?
                Color.WHITE_CELL
                :
                Color.BLACK_CELL;
        this.color = original;
    }

    public void resetColor () {
        color = original;
    }

    public void highlight () {
        if (isEmpty()) {
            if (original == Color.BLACK_CELL)
                color = Color.HIGHLIGHT_BLACK;
            else
                color = Color.HIGHLIGHT_WHITE;

        } else {
            color = (original == Color.BLACK_CELL)
                    ?
                    Color.HIGHLIGHT_KILL_BLACK
                    :
                    Color.HIGHLIGHT_KILL_WHITE;
        }
    }

    // GETTERS
    public Color getCellColor () { return color; }
    public Board getBoard () {
        return board;
    }
    public Piece getPiece () {
        return piece;
    }
    public Coordinate getCoordinate () {
        return coordinate;
    }

    // SET
    public void setPiece (Piece piece) {
        this.piece = piece;
    }

    // METHOD TO CHECK IF THE CELL IS EMPTY
    public boolean isEmpty() {
        return piece == null;
    }

    // METHOD TO CHECK IF THE CELL CONTAINS A PIECE
    public boolean containsPiece () {
        return piece != null;
    }

    // TO STRING METHOD
    @Override
    public String toString() {
        if (isEmpty())
            return colorize("   ", color.getAttribute());
        else
            return colorize(" ", color.getAttribute()) + piece + colorize(" ", color.getAttribute());
    }

    // COLOR ENUM CLASS
    enum Color {
        WHITE_CELL(Attribute.BACK_COLOR(180, 180, 180)),
        BLACK_CELL(Attribute.BACK_COLOR(100, 100, 100)),
        HIGHLIGHT_KILL_WHITE(Attribute.BACK_COLOR(180, 0, 0)),
        HIGHLIGHT_KILL_BLACK(Attribute.BACK_COLOR(130, 0, 0)),
        HIGHLIGHT_WHITE(Attribute.BACK_COLOR(180, 180, 0)),
        HIGHLIGHT_BLACK(Attribute.BACK_COLOR(130, 130, 0));

        // COLOR CLASS ATTRIBUTES
        private final Attribute color;

        // BUILDER
        Color (Attribute color)  {
            this.color = color;
        }

        // GET
        public Attribute getAttribute ()  {
            return color;
        }
    }

}

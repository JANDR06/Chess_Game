package model;

public class Coordinate {

    // COORDINATE CLASS ATTRIBUTES
    private char column;
    private int row;

    // BUILDER
    public Coordinate (char column, int row) {
        this.column = Character.toUpperCase(column);
        this.row = row;
    }

    // GETTERS
    public char getColumn() {
        return column;
    }
    public int getRow() {
        return row;
    }

    // UP COORDINATE METHOD
    public Coordinate up() {
        return new Coordinate(column, row - 1);
    }

    // DOWN COORDINATE METHOD
    public Coordinate down() {
        return new Coordinate(column, row + 1);
    }

    // LEFT COORDINATE METHOD
    public Coordinate left() {
        return new Coordinate((char) (column - 1), row);
    }

    // RIGHT COORDINATE METHOD
    public Coordinate right() {
        return new Coordinate((char) (column + 1), row);
    }

    // DIAGONAL UP LEFT COORDINATE METHOD
    public Coordinate diagonalUpLeft() {
        return up().left();
    }

    // DIAGONAL UP RIGHT COORDINATE METHOD
    public Coordinate diagonalUpRight() {
        return up().right();
    }

    // DIAGONAL DOWN LEFT COORDINATE METHOD
    public Coordinate diagonalDownLeft() {
        return down().left();
    }

    // DIAGONAL DOWN RIGHT COORDINATE METHOD
    public Coordinate diagonalDownRight() {
        return down().right();
    }

    // TO STRING METHOD
    @Override
    public String toString() {
        return "(" + column + "," + row + ")";
    }

    // EQUALS METHOD
    @Override
    public boolean equals (Object o) {

        if (!(o instanceof Coordinate))
            return false;

        Coordinate c = (Coordinate) o;

        return (c.getColumn() == this.column) && (c.getRow() == this.row);
    }

    // HASH METHOD
    @Override public int hashCode() { return row; }

}

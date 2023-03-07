package model;

import java.util.HashSet;
import java.util.Set;

public abstract class Rook extends Piece{

    // BUILDER
    public Rook(Type type, Cell cell) {
        super(type, cell);
    }

    // GET NEXT MOVEMENTS METHOD
    @Override
    public Set<Coordinate> getNextMovements() {
        return Rook.getNextMovementsAsRook(this);
    }

    // GET NEXT MOVEMENTS ROOK METHOD
    public static Set<Coordinate> getNextMovementsAsRook (Piece p) {
        Set<Coordinate> nextMovements = new HashSet<>();
        Cell cell = p.getCell();
        Board board = cell.getBoard();
        Color color = p.getColor();

        Coordinate original = cell.getCoordinate();
        Coordinate c;

        // UP
        c=original.up();
        while(board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            nextMovements.add(c);
            c = c.up();
        }
        
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            nextMovements.add(c);

        // DOWN
        c=original.down();
        while(board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            nextMovements.add(c);
            c = c.down();
        }
        
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            nextMovements.add(c);

        // LEFT
        c=original.left();
        while(board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            nextMovements.add(c);
            c = c.left();
        }
        
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            nextMovements.add(c);

        // RIGHT
        c=original.right();
        while(board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            nextMovements.add(c);
            c = c.right();
        }
        
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            nextMovements.add(c);

        return nextMovements;
    }


}

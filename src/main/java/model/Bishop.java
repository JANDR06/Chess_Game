package model;

import java.util.HashSet;
import java.util.Set;

public abstract class Bishop extends Piece {

    // BUILDER
    public Bishop (Type type, Cell cell){
        super(type, cell);
    }

    // GET NEXT MOVEMENTS METHOD
    @Override
    public Set<Coordinate> getNextMovements(){
        return Bishop.getNextMovementsAsBishop(this);
    }

    // GET NEXT MOVEMENTS BISHOP METHOD
    public static Set<Coordinate> getNextMovementsAsBishop (Piece p) {
        Set<Coordinate> nextMovements = new HashSet<>();
        Cell cell = p.getCell();
        Board board = cell.getBoard();
        Piece.Color color = p.getColor();

        Coordinate original = cell.getCoordinate();
        Coordinate c;

        //DIAGONAL UP LEFT
        c = original.diagonalUpLeft();
        while (board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            nextMovements.add(c);
            c = c.diagonalUpLeft();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            nextMovements.add(c);

        //DIAGONAL UP RIGHT
        c=original.diagonalUpRight();
        while(board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            nextMovements.add(c);
            c = c.diagonalUpRight();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            nextMovements.add(c);

        //DIAGONAL DOWN LEFT
        c=original.diagonalDownLeft();
        while(board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            nextMovements.add(c);
            c = c.diagonalDownLeft();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            nextMovements.add(c);

        //DIAGONAL DOWN RIGHT
        c=original.diagonalDownRight();
        while(board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            nextMovements.add(c);
            c = c.diagonalDownRight();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            nextMovements.add(c);

        return nextMovements;

    }
}
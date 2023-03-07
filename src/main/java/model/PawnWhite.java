package model;

import java.util.HashSet;
import java.util.Set;

public class PawnWhite extends Pawn {

    // BUILDER
    public PawnWhite(Cell cell){
        super(Type.WHITE_PAWN, cell);
    }

    // GET NEXT MOVEMENTS METHOD
    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> nextMovements = new HashSet<>();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        c = position.up();
        checkPawnMove(c);
        if(getCell().getCoordinate().getRow()==7){
            c = position.up().up();
            checkPawnMove(c);
        }

        c=position.diagonalUpLeft();
        checkPawnKiller(c);
        c=position.diagonalUpRight();
        checkPawnKiller(c);

        return nextMovements;

    }

    // TRANSFORM METHOD
    @Override
    public void transform() {
        new QueenWhite(getCell());
        cell=null;
    }

}
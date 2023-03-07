package model;

import java.util.HashSet;
import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;

public class DeletedPieceManager implements IDeletedPieceManager {

    private Set<Piece> pieces;
    public DeletedPieceManager() { pieces = new HashSet<>(); }

    @Override
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }
    public int count(Piece.Type type) {
        return pieces.count(type);
    }
    public Piece removeLast() {
        return pieces.remove(0);
    }



    @Override
    public Piece removeLast (int index) {
        Piece piece = get(pieces.toArray()[index]);
        pieces.remove(piece);
        return piece;
    }


    @Override
    public String toString(){
        String output="";

        for (Piece.Type type : Piece.Type.values())
            output += colorize(" " + type.getShape() +" ",type.getColor().getPieceColor(),Cell.Color.BLACK_CELL.getAttribute());

        output += "\n";

        for (Piece.Type type : Piece.Type.values())
            output += colorize(" " + pieces.count(type) +" ",type.getColor().getPieceColor(),Cell.Color.WHITE_CELL.getAttribute());

        return output;

    }

}

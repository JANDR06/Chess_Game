package model;

public interface IDeletedPieceManager {

    // ADD PIECE METHOD
    void addPiece (Piece piece);

    // COUNT METHOD
    int count (Piece.PieceType pieceType);

    // REMOVE LAST METHOD
    Piece removeLast ();
}

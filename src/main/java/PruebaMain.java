import model.*;
import view.Screen;

public class PruebaMain {
    public static void main (String[] args) {

        Board b = new Board();
        b.placePieces();
        Screen.showBoard(b);
    }
}

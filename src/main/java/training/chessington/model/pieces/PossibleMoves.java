package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;

import java.util.ArrayList;

public class PossibleMoves {
    Coordinates from;
    Board board;
    int rowDir;
    int colDir;

    public static ArrayList<Move> getPossibleMoves(Coordinates from, Board board, int rowDir, int colDir) {
        int i = 1;
        ArrayList<Move> possibleMoves = new ArrayList<>();
        while (from.getRow()+i*rowDir >= 0 && from.getRow()+i*rowDir <= 7 && from.getCol()+i*colDir >= 0 && from.getCol()+i*colDir <= 7 && i < 8) {
            if (board.get(new Coordinates(from.getRow()+i*rowDir, from.getCol()+i*colDir)) == null) {
                possibleMoves.add(new Move(from, from.plus(i*rowDir, i*colDir)));
            } else if (board.get(new Coordinates(from.getRow()+i*rowDir, from.getCol()+i*colDir)).getColour() != board.get(from).getColour()) {
                possibleMoves.add(new Move(from, from.plus(i*rowDir, i*colDir)));
                break;
            } else if (board.get(new Coordinates(from.getRow()+i*rowDir, from.getCol()+i*colDir)) != null) {
                break;
            }
            i++;
        }
        return possibleMoves;
    }
}

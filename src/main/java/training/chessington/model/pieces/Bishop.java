package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> possibleMoves = new ArrayList<>();

        possibleMoves.addAll(getPossibleMoves(from, board, 1, 1));
        possibleMoves.addAll(getPossibleMoves(from, board, -1, 1));
        possibleMoves.addAll(getPossibleMoves(from, board, 1, -1));
        possibleMoves.addAll(getPossibleMoves(from, board, -1, -1));

        return possibleMoves;
    }

    ArrayList<Move> getPossibleMoves(Coordinates from, Board board, int rowDir, int colDir) {
        int i = 1;
        ArrayList<Move> possibleMoves = new ArrayList<>();
        while (from.getRow()+i*rowDir >= 0 &&
                from.getRow()+i*rowDir <= 7 &&
                from.getCol()+i*colDir >= 0 &&
                from.getCol()+i*colDir <= 7 &&
                i < 8 &&
                board.get(new Coordinates(from.getRow()+i*rowDir, from.getCol()+i*colDir)) == null) {
            possibleMoves.add(new Move(from, from.plus(i*rowDir, i*colDir)));
            i++;
        }
        return possibleMoves;
    }
}

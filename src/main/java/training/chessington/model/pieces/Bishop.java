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
        return getMoves(from, board);
    }

    public static List<Move> getMoves(Coordinates from, Board board) {
        List<Move> possibleMoves = new ArrayList<>();

        int[] moveDirections = {-1, 1};
        for (int rowDir : moveDirections) {
            for (int colDir : moveDirections) {
                possibleMoves.addAll(PossibleMoves.getPossibleMoves(from, board, rowDir, colDir));
            }
        }

        return possibleMoves;
    }
}

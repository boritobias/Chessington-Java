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
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                possibleMoves.addAll(PossibleMoves.getPossibleMoves(from, board, moveDirections[i], moveDirections[j]));
            }
        }

        return possibleMoves;
    }
}

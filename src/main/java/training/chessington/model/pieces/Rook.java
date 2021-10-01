package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        return getMoves(from, board);
    }

    public static ArrayList<Move> getMoves(Coordinates from, Board board) {
        ArrayList<Move> possibleMoves = new ArrayList<>();

        int[] moveDirections = {0, -1, 1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (moveDirections[i] != moveDirections[j] && moveDirections[i] != moveDirections[j] * -1) {
                    possibleMoves.addAll(PossibleMoves.getPossibleMoves(from, board, moveDirections[i], moveDirections[j]));
                }
            }
        }

        return possibleMoves;
    }
}

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
        for (int rowDir : moveDirections) {
            for (int colDir : moveDirections) {
                if (rowDir != colDir && rowDir != colDir * -1) {
                    possibleMoves.addAll(PossibleMoves.getPossibleMoves(from, board, rowDir, colDir));
                }

            }
        }

        return possibleMoves;
    }
}

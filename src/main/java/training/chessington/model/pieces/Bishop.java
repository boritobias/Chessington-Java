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
        List<Move> allowedMoves = new ArrayList<>();
        List<Move> possibleMoves = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            possibleMoves.add(new Move(from, from.plus(i, i)));
            possibleMoves.add(new Move(from, from.plus(-i, i)));
            possibleMoves.add(new Move(from, from.plus(i, -i)));
            possibleMoves.add(new Move(from, from.plus(-i, -i)));
        }
        possibleMoves.forEach(move -> {
            allowedMoves.add(move);
        });
        return allowedMoves;
    }
}

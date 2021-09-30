package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> allowedMoves = new ArrayList<>();
        int oneStep = 1;
        int twoStep = 2;
        switch (colour) {
            case WHITE:
                int stepForWhite = -1;
                if (from.getRow() > 0 && board.get(from.plus(oneStep*stepForWhite, 0)) == null) {
                    allowedMoves.add(new Move(from, from.plus(oneStep*stepForWhite, 0)));
                    if (from.getRow() == 6 && board.get(from.plus(twoStep*stepForWhite, 0)) == null) {
                        allowedMoves.add(new Move(from, from.plus(twoStep*stepForWhite, 0)));
                    }
                }
                break;
            case BLACK:
                if (from.getRow() < 7 && board.get(from.plus(oneStep, 0)) == null) {
                    allowedMoves.add(new Move(from, from.plus(oneStep, 0)));
                    if (from.getRow() == 1 && board.get(from.plus(twoStep, 0)) == null) {
                        allowedMoves.add(new Move(from, from.plus(twoStep, 0)));
                    }
                }
        }
        return allowedMoves;
    }
}

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
        switch (colour) {
            case WHITE:
                // not at the top edge
                if (from.getRow() > 0) {
                    // one in front is empty
                    if (board.get(from.plus(-1, 0)) == null) {
                        allowedMoves.add(new Move(from, from.plus(-1, 0)));
                        // in initial position and two in front is empty
                        if (from.getRow() == 6 && board.get(from.plus(-2, 0)) == null) {
                            allowedMoves.add(new Move(from, from.plus(-2, 0)));
                        }
                    }
                    // not at the right most column
                    if (from.getCol() < 7) {
                        // right diagonal is not empty and it's a black piece
                        if (board.get(from.plus(-1, 1)) != null && board.get(from.plus(-1, 1)).getColour() == PlayerColour.BLACK) {
                            allowedMoves.add(new Move(from, from.plus(-1, 1)));
                        }
                    }
                    // not at the left most column
                    if (from.getCol() > 0) {
                        // left diagonal is not empty and it's a black piece
                        if (board.get(from.plus(-1, -1)) != null && board.get(from.plus(-1, -1)).getColour() == PlayerColour.BLACK) {
                            allowedMoves.add(new Move(from, from.plus(-1, -1)));
                        }
                    }
                }
                break;
            case BLACK:
                if (from.getRow() < 7) {
                    if (board.get(from.plus(1, 0)) == null) {
                        allowedMoves.add(new Move(from, from.plus(1, 0)));
                        if (from.getRow() == 1 && board.get(from.plus(2, 0)) == null) {
                            allowedMoves.add(new Move(from, from.plus(2, 0)));
                        }
                    }
                    if (from.getCol() < 7) {
                        if (board.get(from.plus(1, 1)) != null && board.get(from.plus(1, 1)).getColour() == PlayerColour.WHITE) {
                            allowedMoves.add(new Move(from, from.plus(1, 1)));

                        }
                    }
                    if (from.getCol() > 0) {
                        if (board.get(from.plus(1, -1)) != null && board.get(from.plus(1, -1)).getColour() == PlayerColour.WHITE) {
                            allowedMoves.add(new Move(from, from.plus(1, -1)));
                        }
                    }
                }
                break;
        }
        return allowedMoves;
    }
}

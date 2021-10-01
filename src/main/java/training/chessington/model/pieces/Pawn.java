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

        int whiteDirection = -1;
        int whiteStartingRow = 6;
        int blackDirection = 1;
        int blackStartingRow = 1;

        switch (colour) {
            case WHITE:
                return getPossibleMoves(from, board, whiteDirection, whiteStartingRow);
            case BLACK:
                return getPossibleMoves(from, board, blackDirection,blackStartingRow);
        }
        return allowedMoves;
    }

    ArrayList<Move> getPossibleMoves(Coordinates from, Board board, int direction, int startingRow) {
        ArrayList<Move> possibleMoves = new ArrayList<>();

        // check if next step is inside board
        if (from.getRow()+direction >= 0 && from.getRow()+direction <= 7) {
            // check if one move square is empty
            if (board.get(from.plus(direction, 0)) == null) {
                possibleMoves.add(new Move(from, from.plus(direction, 0)));
                // check if in starting position and two move square is empty
                if (from.getRow() == startingRow && board.get(from.plus(2*direction, 0)) == null) {
                    possibleMoves.add(new Move(from, from.plus(2 * direction, 0)));
                }
            }

            int[] moves = {-1, 1};
            for (int move : moves) {
                // check if diagonal square is inside board and not empty, and it's enemy colour
                if (from.getCol()+move >= 0 && from.getCol()+move <= 7 && board.get(from.plus(direction, move)) != null && board.get(from.plus(direction, move)).getColour() != board.get(from).getColour()) {
                    possibleMoves.add(new Move(from, from.plus(direction, move)));
                }
            }
        }

        return possibleMoves;
    }
}

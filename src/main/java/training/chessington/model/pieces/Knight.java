package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();
        List<Move> possibleMoves = new ArrayList<>();

        int[] moveDirections = {-2, -1, 1, 2};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (moveDirections[i] != moveDirections[j] && moveDirections[i] != moveDirections[j] * -1) {
                    possibleMoves.add(new Move(from, from.plus(moveDirections[i], moveDirections[j])));
                }
            }
        }

        possibleMoves.forEach(move -> {
            int row = move.getTo().getRow();
            int col = move.getTo().getCol();
            if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
                if (board.get(new Coordinates(row, col)) == null || board.get(new Coordinates(row, col)).getColour() != board.get(from).getColour()) {
                    allowedMoves.add(move);
                }
            }
        });

        return allowedMoves;
    }
}

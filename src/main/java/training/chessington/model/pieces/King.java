package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> allowedMoves = new ArrayList<>();

        ArrayList<Move> possibleMoves = new ArrayList<>();

        int[] directions = {-1, 0, 1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    possibleMoves.add(new Move(from, from.plus(directions[i], directions[j])));
                }
            }
        }

        possibleMoves.forEach(move -> {
            int row = move.getTo().getRow();
            int col = move.getTo().getCol();
            if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
                allowedMoves.add(move);
            }
        });

        return allowedMoves;
    }
}

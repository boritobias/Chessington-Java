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
        ArrayList<Move> possibleMoves = new ArrayList<>();

        int[] moveDirections = {0, -1, 1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (moveDirections[i] != moveDirections[j] && moveDirections[i] != moveDirections[j] * -1) {
                    possibleMoves.addAll(getPossibleMoves(from, board, moveDirections[i], moveDirections[j]));
                }
            }
        }

        return possibleMoves;
    }

    ArrayList<Move> getPossibleMoves(Coordinates from, Board board, int rowDir, int colDir) {
        int i = 1;
        ArrayList<Move> possibleMoves = new ArrayList<>();
        while (from.getRow()+i*rowDir >= 0 && from.getRow()+i*rowDir <= 7 && from.getCol()+i*colDir >= 0 && from.getCol()+i*colDir <= 7 && i < 8) {
            if (board.get(new Coordinates(from.getRow()+i*rowDir, from.getCol()+i*colDir)) == null) {
                possibleMoves.add(new Move(from, from.plus(i*rowDir, i*colDir)));
            } else if (board.get(new Coordinates(from.getRow()+i*rowDir, from.getCol()+i*colDir)).getColour() != board.get(from).getColour()) {
                possibleMoves.add(new Move(from, from.plus(i*rowDir, i*colDir)));
                break;
            } else if (board.get(new Coordinates(from.getRow()+i*rowDir, from.getCol()+i*colDir)) != null) {
                break;
            }
            i++;
        }
        return possibleMoves;
    }
}

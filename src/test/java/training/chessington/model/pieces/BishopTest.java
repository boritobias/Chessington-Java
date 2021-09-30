package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {
    @Test
    public void blackSquaredBishopCanMoveDiagonally() {
        // Arrange
        Board board = Board.empty();
        Piece blackSquaredBishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 3);
        board.placePiece(coords, blackSquaredBishop);

        // Act
        List<Move> moves = blackSquaredBishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
    }

    @Test
    public void bishopCannotMoveOffTheBoard() {
        // Arrange
        Board board = Board.empty();
        Piece blackSquaredBishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 2);
        board.placePiece(coords, blackSquaredBishop);

        // Act
        List<Move> moves = blackSquaredBishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 2)));
    }

    @Test
    public void blackSquaredBishopCannotMoveToWhiteSquare() {
        // Arrange
        Board board = Board.empty();
        Piece blackSquaredBishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 3);
        board.placePiece(coords, blackSquaredBishop);

        // Act
        List<Move> moves = blackSquaredBishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(5, 3)));
    }

    @Test
    public void whiteSquaredBishopCannotMoveToBlackSquare() {
        // Arrange
        Board board = Board.empty();
        Piece whiteSquaredBishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, whiteSquaredBishop);

        // Act
        List<Move> moves = whiteSquaredBishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(5, 4)));
    }
}

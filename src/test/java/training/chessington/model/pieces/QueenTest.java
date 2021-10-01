package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class QueenTest {
    @Test
    public void queenCanMoveDiagonally() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 3);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
    }

    @Test
    public void queenCanMoveHorizontally() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 0);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, new Coordinates(7, 5)));
    }

    @Test
    public void queenCanMoveVertically() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 0);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, new Coordinates(3, 0)));
    }

    @Test
    public void QueenCannotMoveOffTheBoard() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, -3)));
    }

    @Test
    public void queenCannotJumpOverAnotherPiece() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(5, 5);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(queenCoords, queenCoords.plus(3, 3)));
    }

    @Test
    public void whiteQueenCanCaptureABlackPiece() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(6, 6);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).contains(new Move(queenCoords, pawnCoords));
    }

    @Test
    public void queenCannotMoveOnAWhitePiece() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(5, 5);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(queenCoords, pawnCoords));
    }
}

package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class RookTest {
    @Test
    public void rookCanMoveHorizontally() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 0);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, new Coordinates(7, 5)));
    }

    @Test
    public void rookCanMoveVertically() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 0);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, new Coordinates(3, 0)));
    }

    @Test
    public void rookCannotMoveOffTheBoard() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, 0)));
    }

    @Test
    public void rookCannotJumpOverAnotherPiece() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(7, 0);
        board.placePiece(rookCoords, rook);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(6, 0);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(rookCoords, pawnCoords));
    }

    @Test
    public void whiteRookCanCaptureABlackPiece() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(7, 0);
        board.placePiece(rookCoords, rook);

        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(6, 0);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).contains(new Move(rookCoords, pawnCoords));
    }

    @Test
    public void whiteRookCannotMoveOnAWhitePiece() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(7, 0);
        board.placePiece(rookCoords, rook);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(6, 0);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = rook.getAllowedMoves(rookCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(rookCoords, pawnCoords));
    }
}

package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KingTest {
    @Test
    public void kingCanMoveOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords));
    }

    @Test
    public void kingCannotMoveOffTheBoard() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 3);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, 0)));
    }

    @Test
    public void whiteKingCannotMoveOnAWhitePiece() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates kingCoords = new Coordinates(7, 3);
        board.placePiece(kingCoords, king);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(6, 3);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = king.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(kingCoords, pawnCoords));
    }

    @Test
    public void whiteKingCanCaptureBlackPiece() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates kingCoords = new Coordinates(7, 3);
        board.placePiece(kingCoords, king);

        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(6, 3);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = king.getAllowedMoves(kingCoords, board);

        // Assert
        assertThat(moves).contains(new Move(kingCoords, pawnCoords));
    }

    @Test
    public void whiteKingCannotMoveInCheck() {
        // Arrange
        Board board = Board.empty();
        Piece whiteKing = new King(PlayerColour.WHITE);
        Coordinates whiteKingCoords = new Coordinates(7, 3);
        board.placePiece(whiteKingCoords, whiteKing);

        Piece blackQueen = new Queen(PlayerColour.BLACK);
        Coordinates blackQueenCoords = new Coordinates(3, 4);
        board.placePiece(blackQueenCoords, blackQueen);

        // Act
        List<Move> moves = whiteKing.getAllowedMoves(whiteKingCoords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(whiteKingCoords, whiteKingCoords.plus(-1, 1)));
    }

}

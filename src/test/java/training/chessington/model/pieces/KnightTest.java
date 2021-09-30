package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {
    @Test
    public void knightCanMoveInLShape() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));
    }

    @Test
    public void whiteKnightCannotMoveOnAnotherWhitePiece() {
        // Arrange
        Board board = Board.empty();

        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates knightCoords = new Coordinates(4, 4);
        board.placePiece(knightCoords, knight);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(6, 5);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> knightMoves = knight.getAllowedMoves(knightCoords, board);

        // Assert
        assertThat(knightMoves).doesNotContain(new Move(knightCoords, knightCoords.plus(2, 1)));
    }

    @Test
    public void whiteKnightCanCaptureABlackPiece() {
        // Arrange
        Board board = Board.empty();

        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates knightCoords = new Coordinates(4, 4);
        board.placePiece(knightCoords, knight);

        Piece blackPawn = new Pawn(PlayerColour.BLACK);
        Coordinates blackPawnCoords = new Coordinates(2, 5);
        board.placePiece(blackPawnCoords, blackPawn);

        // Act
        List<Move> knightMoves = knight.getAllowedMoves(knightCoords, board);

        // Assert
        assertThat(knightMoves).contains(new Move(knightCoords, knightCoords.plus(-2, 1)));
    }
}

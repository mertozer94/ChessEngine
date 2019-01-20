package moves

import board.{BitBoard, Board, Square}
import org.scalatest.FlatSpec
import piece.WhiteKing

class KingMovesTest extends FlatSpec {
  info("King Moves tests")
  "Valid KingMoves on square E1 without another piece on the board" should "be 0x141C000000000000L" in {
    Board.createDefaultBoard()
    val whiteKing: BitBoard = Board.getWhiteKing

    val response = KingMoves.generateMoves(whiteKing.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(0x141C000000000000L))
  }
  "Valid KingMoves on square E1 surrounded with other pieces" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val whiteKing: BitBoard = Board.getWhiteKing

    val response = KingMoves.generateMoves(whiteKing.getPieces(0), 0x141C000000000000L, 0x0000000000000000L)

    assert(response.equals(0x0000000000000000L))
  }

  "Valid KingMoves on square E8 without another piece on the board" should "be 0x0000000000001C14L" in {
    Board.createDefaultBoard()
    val blackKing: BitBoard = Board.getBlackKing

    val response = KingMoves.generateMoves(blackKing.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(0x0000000000001C14L))
  }
  "Valid KingMoves on square E8 surrounded with other pieces" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val blackKing: BitBoard = Board.getBlackKing

    val response = KingMoves.generateMoves(blackKing.getPieces(0), 0x0000000000001C14L, 0x0000000000000000L)

    assert(response.equals(0x0000000000000000L))
  }
  "Valid KingMoves on square D4 without any piece on the board" should "be 0x0000382838000000L" in {
    Board.createDefaultBoard()
    val blackKing: BitBoard = BitBoard()
    val aKing = WhiteKing(Square.D4)
    blackKing.addPiece(aKing)

    val response = KingMoves.generateMoves(blackKing.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(0x0000382838000000L))
  }
  "Valid KingMoves on square D4 surrounded with other pieces" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val blackKing: BitBoard = BitBoard()
    val aKing = WhiteKing(Square.D4)
    blackKing.addPiece(aKing)

    val response = KingMoves.generateMoves(blackKing.getPieces(0), 0x0000382838000000L, 0x0000000000000000L)

    assert(response.equals(0x0000000000000000L))
  }
}
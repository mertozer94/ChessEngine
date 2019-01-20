package moves

import board.{BitBoard, Board, Square}
import org.scalatest.FlatSpec
import piece.WhiteKnight

class KnightMovesTest extends FlatSpec {
  info("Knight Moves tests")
  "Valid Knight Moves on square B1 without another piece on the board" should "0x0010A00000000000L" in {
    Board.createDefaultBoard()
    val whiteKnight: BitBoard = Board.getWhiteKnights

    val response = KnightMoves.generateMoves(whiteKnight.getPieces(0), 0x0000000000000000L)

    print(response.toBinaryString)
    assert(response.equals(0x0010A00000000000L))
  }
  "Valid Knight Moves on square B1 surrounded with other pieces" should "0x0000000000000000L" in {
    Board.createDefaultBoard()
    val whiteKnight: BitBoard = Board.getWhiteKnights

    val response = KnightMoves.generateMoves(whiteKnight.getPieces(0), 0x0010A00000000000L)

    print(response.toBinaryString)
    assert(response.equals(0x0000000000000000L))
  }

  "Valid Knight Moves on square H1 without another piece on the board" should "0x0008050000000000L" in {
    Board.createDefaultBoard()
    val whiteKnight: BitBoard = Board.getWhiteKnights

    val response = KnightMoves.generateMoves(whiteKnight.getPieces(1), 0x0000000000000000L)

    print(response.toBinaryString)
    assert(response.equals(0x0008050000000000L))
  }
  "Valid Knight Moves on square H1 surrounded with other pieces" should "0x0000000000000000L" in {
    Board.createDefaultBoard()
    val whiteKnight: BitBoard = Board.getWhiteKnights

    val response = KnightMoves.generateMoves(whiteKnight.getPieces(1), 0x0008050000000000L)

    print(response.toBinaryString)
    assert(response.equals(0x0000000000000000L))
  }
  "Valid Knight Moves on square D4 without any piece on the board" should "be 0x0028440044280000L" in {
    Board.createDefaultBoard()
    val whiteKnight: BitBoard = BitBoard()
    val aKnight = WhiteKnight(Square.D4)
    whiteKnight.addPiece(aKnight)

    val response = KnightMoves.generateMoves(whiteKnight.getPieces(0), 0x0000000000000000L)

    assert(response.equals(0x0028440044280000L))
  }
  "Valid Knight Moves on square D4 surrounded with other pieces" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val whiteKnight: BitBoard = BitBoard()
    val aKnight = WhiteKnight(Square.D4)
    whiteKnight.addPiece(aKnight)

    val response = KnightMoves.generateMoves(whiteKnight.getPieces(0), 0x0028440044280000L)

    assert(response.equals(0x0000000000000000L))
  }
}

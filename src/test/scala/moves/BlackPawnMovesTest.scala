package moves

import board.{BitBoard, Board, Square}
import lookup.PieceLookup
import org.scalatest.FlatSpec
import piece.BlackPawn

class BlackPawnMovesTest extends FlatSpec {

  info("Black Pawn Moves tests")
  "Valid Black Pawn Moves on square A7 without another piece on the board" should "A6 and A5" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val aPawn = BlackPawn(Square.A7)
    pawns.addPiece(aPawn)

    val a6 = PieceLookup.value(Square.A6)
    val a5 = PieceLookup.value(Square.A5)

    val response = BlackPawnMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(a6 | a5))
  }
  "Valid Black Pawn Moves on square A7 with a pawn to capture on B6" should "be A6 A5 B6" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val otherSide = PieceLookup.value(Square.B6)
    val aPawn = BlackPawn(Square.A7)
    pawns.addPiece(aPawn)

    val a6 = PieceLookup.value(Square.A6)
    val a5 = PieceLookup.value(Square.A5)

    val response = BlackPawnMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, otherSide)

    assert(response.equals(a6 | a5 | otherSide))
  }
  "Valid Black Pawn Moves on square A7 with a black pawn on B6" should "be A6 A5" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val ownSide = PieceLookup.value(Square.B6)
    val aPawn = BlackPawn(Square.A7)
    pawns.addPiece(aPawn)

    val a6 = PieceLookup.value(Square.A6)
    val a5 = PieceLookup.value(Square.A5)

    val response = BlackPawnMoves.generateMoves(pawns.getPieces(0), ownSide, 0x0000000000000000L)

    assert(response.equals(a6 | a5))
  }

  "Valid Black Pawn Moves on square B6 with a white piece on B5 the board" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val otherSide = PieceLookup.value(Square.B5)
    val aPawn = BlackPawn(Square.B6)
    pawns.addPiece(aPawn)

    val response = BlackPawnMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, otherSide)

    assert(response.equals(0x0000000000000000L))
  }
  "Valid Black Pawn Moves on square B6 with a black piece on B5 the board" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val ownSide = PieceLookup.value(Square.B5)
    val aPawn = BlackPawn(Square.B6)
    pawns.addPiece(aPawn)

    val response = BlackPawnMoves.generateMoves(pawns.getPieces(0), ownSide, 0x0000000000000000L)

    assert(response.equals(0x0000000000000000L))
  }
  "Valid Black Pawn Moves on square B6 without any another piece on the board" should "be B5" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val aPawn = BlackPawn(Square.B6)
    pawns.addPiece(aPawn)

    val b5 = PieceLookup.value(Square.B5)
    val response = BlackPawnMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(b5))
  }
  "All Valid Black Pawn Moves on square B7 with pieces to capture" should "be B66 B5 A6 C" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val aPawn = BlackPawn(Square.B7)
    pawns.addPiece(aPawn)

    val b6 = PieceLookup.value(Square.B6)
    val b5 = PieceLookup.value(Square.B5)
    val a6 = PieceLookup.value(Square.A6)
    val c6 = PieceLookup.value(Square.C6)
    val expectedSquares = b6 | b5 | a6 | c6
    val whitePieces = a6 | c6
    val response = BlackPawnMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, whitePieces)

    assert(response.equals(expectedSquares))
  }

}

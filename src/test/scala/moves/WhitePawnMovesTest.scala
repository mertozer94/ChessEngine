package moves

import board.{BitBoard, Board, Square}
import lookup.PieceLookup
import org.scalatest.FlatSpec
import piece.WhitePawn

class WhitePawnMovesTest extends FlatSpec {

  info("White Pawn Moves tests")
  "Valid White Pawn Moves on square A2 without another piece on the board" should "be 0x0000808000000000L" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val aPawn = WhitePawn(Square.A2)
    pawns.addPiece(aPawn)

    val response = WhitePawnMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(0x0000808000000000L))
  }
  "Valid White Pawn Moves on square A2 with a pawn to capture on B3" should "be 0x0000C08000000000L" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val otherSide = PieceLookup.value(Square.B3)
    val aPawn = WhitePawn(Square.A2)
    pawns.addPiece(aPawn)

    val response = WhitePawnMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, otherSide)

    assert(response.equals(0x0000C08000000000L))
  }
  "Valid White Pawn Moves on square A2 with a white pawn on B3" should "be 0x0000808000000000L" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val ownSide = PieceLookup.value(Square.B3)
    val aPawn = WhitePawn(Square.A2)
    pawns.addPiece(aPawn)

    val response = WhitePawnMoves.generateMoves(pawns.getPieces(0), ownSide, 0x0000000000000000L)

    assert(response.equals(0x0000808000000000L))
  }

  "Valid White Pawn Moves on square B3 with a white piece on B4 the board" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val ownSide = PieceLookup.value(Square.B4)
    val aPawn = WhitePawn(Square.B3)
    pawns.addPiece(aPawn)

    val response = WhitePawnMoves.generateMoves(pawns.getPieces(0), ownSide, 0x0000000000000000L)

    assert(response.equals(0x0000000000000000L))
  }
  "Valid White Pawn Moves on square B3 with a black piece on B4 the board" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val otherSide = PieceLookup.value(Square.B4)
    val aPawn = WhitePawn(Square.B3)
    pawns.addPiece(aPawn)

    val response = WhitePawnMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, otherSide)

    assert(response.equals(0x0000000000000000L))
  }
  "Valid White Pawn Moves on square B3 without any another piece on the board" should "be 0x0000004000000000L" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val aPawn = WhitePawn(Square.B3)
    pawns.addPiece(aPawn)

    val response = WhitePawnMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(0x0000004000000000L))
  }
  "All Valid White Pawn Moves on square B2" should "be 0x0000004000000000L" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val aPawn = WhitePawn(Square.B2)
    pawns.addPiece(aPawn)

    val b3 = PieceLookup.value(Square.B3)
    val b4 = PieceLookup.value(Square.B4)
    val a3 = PieceLookup.value(Square.A3)
    val c3 = PieceLookup.value(Square.C3)
    val expectedSquares = b3 | b4 | a3 | c3
    val blackPieces = a3 | c3
    val response = WhitePawnMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, blackPieces)

    assert(response.equals(expectedSquares))
  }

}

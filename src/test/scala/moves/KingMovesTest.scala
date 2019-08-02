package moves

import board.{BitBoard, Board, Square}
import lookup.PieceLookup
import org.scalatest.FlatSpec
import piece.{BlackKing, BlackRook, WhiteKing, WhiteRook}

class KingMovesTest extends FlatSpec {
  info("King Moves tests")
  "Valid KingMoves on square E1 without another piece on the board" should "be 0x141C000000000000L" in {
    Board.createDefaultBoard()
    val whiteKing: BitBoard = Board.getWhiteKing
    val otherSide = BitBoard()
    val bRook1 = BlackRook(Square.G1)
    val bRook2 = BlackRook(Square.B1)
    otherSide.addPiece(bRook1)
    otherSide.addPiece(bRook2)
    val response = KingMoves.generateMoves(whiteKing.getPieces(0), 0x0000000000000000L, otherSide.binaryRep)

    assert(response.equals(0x141C000000000000L))
  }
  "Valid KingMoves on square E1 surrounded with other pieces" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val whiteKing: BitBoard = Board.getWhiteKing
    val otherSide = BitBoard()
    val bRook1 = BlackRook(Square.G1)
    val bRook2 = BlackRook(Square.B1)
    otherSide.addPiece(bRook1)
    otherSide.addPiece(bRook2)
    val response = KingMoves.generateMoves(whiteKing.getPieces(0), 0x141C000000000000L, otherSide.binaryRep)

    assert(response.equals(0x0000000000000000L))
  }

  "Valid KingMoves on square E8 without another piece on the board" should "be 0x0000000000001C14L" in {
    Board.createDefaultBoard()
    val blackKing: BitBoard = Board.getBlackKing
    val otherSide = BitBoard()
    val bRook1 = BlackRook(Square.G8)
    val bRook2 = BlackRook(Square.B8)
    otherSide.addPiece(bRook1)
    otherSide.addPiece(bRook2)
    val response = KingMoves.generateMoves(blackKing.getPieces(0), 0x0000000000000000L, otherSide.binaryRep)

    assert(response.equals(0x0000000000001C14L))
  }
  "Valid KingMoves on square E8 surrounded with other pieces" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val blackKing: BitBoard = Board.getBlackKing
    val otherSide = BitBoard()
    val bRook1 = BlackRook(Square.G8)
    val bRook2 = BlackRook(Square.B8)
    otherSide.addPiece(bRook1)
    otherSide.addPiece(bRook2)
    val response = KingMoves.generateMoves(blackKing.getPieces(0), 0x0000000000001C14L, otherSide.binaryRep)

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

  "All Valid White King Moves on square E1, can castle both ways" should "be regular + c1 + g1" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val wKing = WhiteKing(Square.E1)
    val wRook = WhiteRook(Square.H1)

    pawns.addPiece(wKing)
    pawns.addPiece(wRook)

    val d2 = PieceLookup.value(Square.D2)
    val e2 = PieceLookup.value(Square.E2)
    val f2 = PieceLookup.value(Square.F2)
    val d1 = PieceLookup.value(Square.D1)
    val f1 = PieceLookup.value(Square.F1)
    val g1 = PieceLookup.value(Square.G1)
    val c1 = PieceLookup.value(Square.C1)

    val expectedSquares = d2 | e2 | f2 | d1 | f1 | g1 | c1
    val response = KingMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(expectedSquares))
  }

  "All Valid White King Moves on square E1, can castle long, own piece is blocking short castle" should "be regular + c1" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val wKing = WhiteKing(Square.E1)
    val wRook = WhiteRook(Square.H1)

    pawns.addPiece(wKing)
    pawns.addPiece(wRook)

    val d2 = PieceLookup.value(Square.D2)
    val e2 = PieceLookup.value(Square.E2)
    val f2 = PieceLookup.value(Square.F2)
    val d1 = PieceLookup.value(Square.D1)
    val f1 = PieceLookup.value(Square.F1)
    val c1 = PieceLookup.value(Square.C1)

    val expectedSquares = d2 | e2 | f2 | d1 | c1
    val response = KingMoves.generateMoves(pawns.getPieces(0), f1, 0x0000000000000000L)

    assert(response.equals(expectedSquares))
  }
  "All Valid White King Moves on square E1, can castle long, other piece is blocking short castle" should "be regular + c1" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val wKing = WhiteKing(Square.E1)
    val wRook = WhiteRook(Square.H1)

    pawns.addPiece(wKing)
    pawns.addPiece(wRook)

    val d2 = PieceLookup.value(Square.D2)
    val e2 = PieceLookup.value(Square.E2)
    val f2 = PieceLookup.value(Square.F2)
    val d1 = PieceLookup.value(Square.D1)
    val f1 = PieceLookup.value(Square.F1)
    val c1 = PieceLookup.value(Square.C1)

    val expectedSquares = d2 | e2 | f2 | d1 | f1 | c1
    val response = KingMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, f1)

    assert(response.equals(expectedSquares))
  }


  "All Valid White King Moves on square E1, can castle short, own piece is blocking long castle" should "be regular + g1" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val wKing = WhiteKing(Square.E1)
    val wRook = WhiteRook(Square.H1)

    pawns.addPiece(wKing)
    pawns.addPiece(wRook)

    val d2 = PieceLookup.value(Square.D2)
    val e2 = PieceLookup.value(Square.E2)
    val f2 = PieceLookup.value(Square.F2)
    val d1 = PieceLookup.value(Square.D1)
    val f1 = PieceLookup.value(Square.F1)
    val g1 = PieceLookup.value(Square.G1)
    val c1 = PieceLookup.value(Square.C1)

    val expectedSquares = d2 | e2 | f2 | d1 | f1 | g1
    val response = KingMoves.generateMoves(pawns.getPieces(0), c1, 0x0000000000000000L)

    assert(response.equals(expectedSquares))
  }

  "All Valid White King Moves on square E1, can castle short, other piece is blocking long castle" should "be regular + g1" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val wKing = WhiteKing(Square.E1)
    val wRook = WhiteRook(Square.H1)

    pawns.addPiece(wKing)
    pawns.addPiece(wRook)

    val d2 = PieceLookup.value(Square.D2)
    val e2 = PieceLookup.value(Square.E2)
    val f2 = PieceLookup.value(Square.F2)
    val d1 = PieceLookup.value(Square.D1)
    val f1 = PieceLookup.value(Square.F1)
    val g1 = PieceLookup.value(Square.G1)
    val c1 = PieceLookup.value(Square.C1)

    val expectedSquares = d2 | e2 | f2 | d1 | f1 | g1
    val response = KingMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, c1)

    assert(response.equals(expectedSquares))
  }


  "All Valid Black King Moves on square E8, can castle both ways" should "be  regular + c8 + g8" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val bKing = BlackKing(Square.E8)
    val bRook = BlackRook(Square.H8)

    pawns.addPiece(bKing)
    pawns.addPiece(bRook)

    val d7 = PieceLookup.value(Square.D7)
    val e7 = PieceLookup.value(Square.E7)
    val f7 = PieceLookup.value(Square.F7)
    val d8 = PieceLookup.value(Square.D8)
    val f8 = PieceLookup.value(Square.F8)
    val g8 = PieceLookup.value(Square.G8)
    val c8 = PieceLookup.value(Square.C8)

    val expectedSquares = d7 | e7 | f7 | d8 | f8 | g8 | c8
    val response = KingMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(expectedSquares))
  }

  "All Valid Black King Moves on square E8, can castle long, own piece is blocking short castle" should "be regular + c8" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val bKing = BlackKing(Square.E8)
    val bRook = BlackRook(Square.H8)

    pawns.addPiece(bKing)
    pawns.addPiece(bRook)

    val d7 = PieceLookup.value(Square.D7)
    val e7 = PieceLookup.value(Square.E7)
    val f7 = PieceLookup.value(Square.F7)
    val d8 = PieceLookup.value(Square.D8)
    val f8 = PieceLookup.value(Square.F8)
    val c8 = PieceLookup.value(Square.C8)

    val expectedSquares = d7 | e7 | f7 | d8 | c8
    val response = KingMoves.generateMoves(pawns.getPieces(0), f8, 0x0000000000000000L)

    assert(response.equals(expectedSquares))
  }
  "All Valid Black King Moves on square E8, can castle long, other piece is blocking short castle" should "be regular + c8" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val bKing = BlackKing(Square.E8)
    val bRook = BlackRook(Square.H8)

    pawns.addPiece(bKing)
    pawns.addPiece(bRook)

    val d7 = PieceLookup.value(Square.D7)
    val e7 = PieceLookup.value(Square.E7)
    val f7 = PieceLookup.value(Square.F7)
    val d8 = PieceLookup.value(Square.D8)
    val f8 = PieceLookup.value(Square.F8)
    val c8 = PieceLookup.value(Square.C8)

    val expectedSquares = d7 | e7 | f7 | d8 | f8 | c8
    val response = KingMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, f8)

    assert(response.equals(expectedSquares))
  }


  "All Valid Black King Moves on square E8, can castle short, own piece is blocking long castle" should "be regular + g8" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val bKing = BlackKing(Square.E8)
    val bRook = BlackRook(Square.H8)

    pawns.addPiece(bKing)
    pawns.addPiece(bRook)

    val d7 = PieceLookup.value(Square.D7)
    val e7 = PieceLookup.value(Square.E7)
    val f7 = PieceLookup.value(Square.F7)
    val d8 = PieceLookup.value(Square.D8)
    val f8 = PieceLookup.value(Square.F8)
    val g8 = PieceLookup.value(Square.G8)
    val c8 = PieceLookup.value(Square.C8)

    val expectedSquares = d7 | e7 | f7 | d8 | f8 | g8
    val response = KingMoves.generateMoves(pawns.getPieces(0), c8, 0x0000000000000000L)

    assert(response.equals(expectedSquares))
  }

  "All Valid Black King Moves on square E8, can castle short, other piece is blocking long castle" should "be regular + g8" in {
    Board.createDefaultBoard()
    val pawns = BitBoard()
    val bKing = BlackKing(Square.E8)
    val bRook = BlackRook(Square.H8)

    pawns.addPiece(bKing)
    pawns.addPiece(bRook)

    val d7 = PieceLookup.value(Square.D7)
    val e7 = PieceLookup.value(Square.E7)
    val f7 = PieceLookup.value(Square.F7)
    val d8 = PieceLookup.value(Square.D8)
    val f8 = PieceLookup.value(Square.F8)
    val g8 = PieceLookup.value(Square.G8)
    val c8 = PieceLookup.value(Square.C8)

    val expectedSquares = d7 | e7 | f7 | d8 | f8 | g8
    val response = KingMoves.generateMoves(pawns.getPieces(0), 0x0000000000000000L, c8)

    assert(response.equals(expectedSquares))
  }
}
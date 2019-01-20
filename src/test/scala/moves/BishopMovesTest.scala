package moves

import board.{BitBoard, Board, Square}
import org.scalatest.FlatSpec
import piece.{BlackPawn, WhiteBishop, WhitePawn}

class BishopMovesTest extends FlatSpec {

  info("Bishop Moves tests")
  "Valid White Bishop Moves on square A1 without another piece on the board" should "be 0x0040201008040201L" in {
    Board.createDefaultBoard()
    val bishops = BitBoard()
    val aPawn = WhiteBishop(Square.A1)
    bishops.addPiece(aPawn)

    val response = BishopMoves.generateMoves(bishops.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(0x0040201008040201L))
  }
  "Valid White Bishop Moves on square A1 with a white piece on A2 on the board" should "be 0x0040201008040201L" in {
    Board.createDefaultBoard()
    val bishops = BitBoard()
    val aPawn = WhiteBishop(Square.A1)
    bishops.addPiece(aPawn)

    val ownSide = BitBoard()
    val whitePiece = WhitePawn(Square.A2)
    ownSide.addPiece(whitePiece)

    val response = BishopMoves.generateMoves(bishops.getPieces(0), ownSide.binaryRep, 0x0000000000000000L)

    assert(response.equals(0x0040201008040201L))
  }
  "Valid White Bishop Moves on square A1 with a white piece on B2 on the board" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val bishops = BitBoard()
    val aPawn = WhiteBishop(Square.A1)
    bishops.addPiece(aPawn)

    val ownSide = BitBoard()
    val whitePiece = WhitePawn(Square.B2)
    ownSide.addPiece(whitePiece)

    val response = BishopMoves.generateMoves(bishops.getPieces(0), ownSide.binaryRep, 0x0000000000000000L)

    assert(response.equals(0x0000000000000000L))
  }
  "Valid White Bishop Moves on square A1 with a black piece on B2 on the board" should "be 0x0040000000000000L" in {
    Board.createDefaultBoard()
    val bishops = BitBoard()
    val aPawn = WhiteBishop(Square.A1)
    bishops.addPiece(aPawn)

    val otherSide = BitBoard()
    val whitePiece = BlackPawn(Square.B2)
    otherSide.addPiece(whitePiece)

    val response = BishopMoves.generateMoves(bishops.getPieces(0), 0x0000000000000000L, otherSide.binaryRep)

    assert(response.equals(0x0040000000000000L))
  }

  "Valid White Bishop Moves on square A1 with a black piece on C3 on the board" should "be 0x0040200000000000L" in {
    Board.createDefaultBoard()
    val bishops = BitBoard()
    val aPawn = WhiteBishop(Square.A1)
    bishops.addPiece(aPawn)

    val otherSide = BitBoard()
    val whitePiece = BlackPawn(Square.C3)
    otherSide.addPiece(whitePiece)

    val response = BishopMoves.generateMoves(bishops.getPieces(0), 0x0000000000000000L, otherSide.binaryRep)

    assert(response.equals(0x0040200000000000L))
  }

  "Valid White Bishop Moves on square A1 with a black piece on C3 and a white piece on B2 on the board" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val bishops = BitBoard()
    val aPawn = WhiteBishop(Square.A1)
    bishops.addPiece(aPawn)

    val otherSide = BitBoard()
    val whitePiece = BlackPawn(Square.C3)
    otherSide.addPiece(whitePiece)

    val ownSide = BitBoard()
    val whitePiece1 = BlackPawn(Square.B2)
    ownSide.addPiece(whitePiece1)

    val response = BishopMoves.generateMoves(bishops.getPieces(0), ownSide.binaryRep, otherSide.binaryRep)

    assert(response.equals(0x0000000000000000L))
  }


  "Valid White Bishop Moves on square D4 with any piece on the board" should "be 0x0000000000000000L" in {
    Board.createDefaultBoard()
    val bishops = BitBoard()
    val aPawn = WhiteBishop(Square.D4)
    bishops.addPiece(aPawn)


    val response = BishopMoves.generateMoves(bishops.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(0x8244280028448201L))
  }

}

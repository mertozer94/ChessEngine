package moves

import board.{BitBoard, Board, Square}
import org.scalatest.FlatSpec
import piece.{BlackPawn, WhitePawn, WhiteRook}

class RookMovesTest extends FlatSpec {
  info("Rook Moves tests")
  "Valid White Rook Moves on square A1 without another piece on the board" should "be 0x7F80808080808080L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.A1)
    rooks.addPiece(aPawn)

    val response = RookMoves.generateMoves(rooks.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(0x7F80808080808080L))
  }
  "Valid White Rook Moves on square A1 with a white piece on A2 on the board" should "be 0x7F00000000000000L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.A1)
    rooks.addPiece(aPawn)

    val ownSide = BitBoard()
    val whitePiece = WhitePawn(Square.A2)
    ownSide.addPiece(whitePiece)

    val response = RookMoves.generateMoves(rooks.getPieces(0), ownSide.binaryRep, 0x0000000000000000L)

    assert(response.equals(0x7F00000000000000L))
  }
  "Valid White Rook Moves on square A1 with a white piece on B1 on the board" should "be 0x0080808080808080L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.A1)
    rooks.addPiece(aPawn)

    val ownSide = BitBoard()
    val whitePiece = WhitePawn(Square.B1)
    ownSide.addPiece(whitePiece)

    val response = RookMoves.generateMoves(rooks.getPieces(0), ownSide.binaryRep, 0x0000000000000000L)

    assert(response.equals(0x0080808080808080L))
  }
  "Valid White Rook Moves on square A1 with a black piece on A2 on the board" should "be 0x7F80000000000000L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.A1)
    rooks.addPiece(aPawn)

    val otherSide = BitBoard()
    val blackPiece = BlackPawn(Square.A2)
    otherSide.addPiece(blackPiece)

    val response = RookMoves.generateMoves(rooks.getPieces(0), 0x0000000000000000L, otherSide.binaryRep)

    assert(response.equals(0x7F80000000000000L))
  }
  "Valid White Rook Moves on square A1 with a black piece on B1 on the board" should "be 0x4080808080808080L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.A1)
    rooks.addPiece(aPawn)

    val otherSide = BitBoard()
    val blackPiece = BlackPawn(Square.B1)
    otherSide.addPiece(blackPiece)

    val response = RookMoves.generateMoves(rooks.getPieces(0), 0x0000000000000000L, otherSide.binaryRep)

    assert(response.equals(0x4080808080808080L))
  }
  "Valid White Rook Moves on square A1 with a black piece on B1, white piece on B2 on the board" should "be 0x4080808080808080L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.A1)
    rooks.addPiece(aPawn)

    val aWhitePiece = WhitePawn(Square.B2)
    val whitePieces = BitBoard()
    whitePieces.addPiece(aWhitePiece)

    val otherSide = BitBoard()
    val blackPiece = BlackPawn(Square.B1)
    otherSide.addPiece(blackPiece)

    val response = RookMoves.generateMoves(rooks.getPieces(0), whitePieces.binaryRep, otherSide.binaryRep)

    assert(response.equals(0x4080808080808080L))
  }
  "Valid White Rook Moves on square A1 with a black piece on B1, white piece on C1 on the board" should "be 0x4080808080808080L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.A1)
    rooks.addPiece(aPawn)

    val aWhitePiece = WhitePawn(Square.C1)
    val whitePieces = BitBoard()
    whitePieces.addPiece(aWhitePiece)

    val otherSide = BitBoard()
    val blackPiece = BlackPawn(Square.B1)
    otherSide.addPiece(blackPiece)

    val response = RookMoves.generateMoves(rooks.getPieces(0), whitePieces.binaryRep, otherSide.binaryRep)

    assert(response.equals(0x4080808080808080L))
  }
  "Valid White Rook Moves on square A1 with a black piece on B1, white piece on A2 on the board" should "be 0x4000000000000000L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.A1)
    rooks.addPiece(aPawn)

    val aWhitePiece = WhitePawn(Square.A2)
    val whitePieces = BitBoard()
    whitePieces.addPiece(aWhitePiece)

    val otherSide = BitBoard()
    val blackPiece = BlackPawn(Square.B1)
    otherSide.addPiece(blackPiece)

    val response = RookMoves.generateMoves(rooks.getPieces(0), whitePieces.binaryRep, otherSide.binaryRep)

    assert(response.equals(0x4000000000000000L))
  }
  "Valid White Rook Moves on square A1 with a black piece on B1, black piece on A2 on the board" should "be 0x4080000000000000L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.A1)
    rooks.addPiece(aPawn)

    val otherSide = BitBoard()
    val blackPiece = BlackPawn(Square.B1)
    val blackPiece2 = BlackPawn(Square.A2)
    otherSide.addPiece(blackPiece)
    otherSide.addPiece(blackPiece2)

    val response = RookMoves.generateMoves(rooks.getPieces(0), 0x0000000000000000L, otherSide.binaryRep)

    assert(response.equals(0x4080000000000000L))
  }

  "Valid White Rook Moves on square D4 without another piece on the board" should "be 0x101010EF10101010L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.D4)
    rooks.addPiece(aPawn)

    val response = RookMoves.generateMoves(rooks.getPieces(0), 0x0000000000000000L, 0x0000000000000000L)

    assert(response.equals(0x101010EF10101010L))
  }

  "Valid White Rook Moves on square D4 with a white piece on E4 on the board" should "be 0x101010E010101010L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.D4)
    rooks.addPiece(aPawn)

    val ownSide = BitBoard()
    val whitePiece = WhitePawn(Square.E4)
    ownSide.addPiece(whitePiece)

    val response = RookMoves.generateMoves(rooks.getPieces(0), ownSide.binaryRep, 0x0000000000000000L)

    assert(response.equals(0x101010E010101010L))
  }
  "Valid White Rook Moves on square D4 with a white piece on E4 on the board" should "be 0x1010100F10101010L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.D4)
    rooks.addPiece(aPawn)

    val ownSide = BitBoard()
    val whitePiece = WhitePawn(Square.E4)
    ownSide.addPiece(whitePiece)

    val response = RookMoves.generateMoves(rooks.getPieces(0), ownSide.binaryRep, 0x0000000000000000L)

    assert(response.equals(0x101010E010101010L))
  }
  "Valid White Rook Moves on square D4 with a black piece on C4 on the board" should "be 0x7F80000000000000L" in {
    Board.createDefaultBoard()
    val rooks = BitBoard()
    val aPawn = WhiteRook(Square.D4)
    rooks.addPiece(aPawn)

    val otherSide = BitBoard()
    val blackPiece = BlackPawn(Square.C4)
    otherSide.addPiece(blackPiece)

    val response = RookMoves.generateMoves(rooks.getPieces(0), 0x0000000000000000L, otherSide.binaryRep)

    assert(response.equals(0x1010102F10101010L))
  }

}

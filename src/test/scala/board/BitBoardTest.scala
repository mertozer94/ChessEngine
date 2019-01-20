package board

import org.scalatest.FlatSpec
import piece.{BlackQueen, PieceCode}

class BitBoardTest extends FlatSpec {

  info("white pawn positions tests")
  "BitBoard addPiece" should "add new pieces" in {
    Board.createDefaultBoard()
    val whitePawns: BitBoard = Board.getWhitePawns
    val blackQueenOnA1 = BlackQueen(Square.A1)
    whitePawns.addPiece(blackQueenOnA1)
    assert(whitePawns.binaryRep.equals(0x80FF000000000000L))
    assert(whitePawns.binaryRepString.equals("1000000011111111000000000000000000000000000000000000000000000000"))
    assert(whitePawns.bitBoard(0)(0).isBlack)
    assert(whitePawns.bitBoard(0)(0).getPieceCode == PieceCode.bqueen)
  }

  info("get pieces pawns tests")
  "Get Pieces" should "return pieces on the board" in {
    Board.createDefaultBoard()
    val whitePawns: BitBoard = Board.getWhitePawns

    assert(whitePawns.getPieces(0).position.equals(Square.A2))
    assert(whitePawns.getPieces(1).position.equals(Square.B2))
    assert(whitePawns.getPieces(2).position.equals(Square.C2))
    assert(whitePawns.getPieces(3).position.equals(Square.D2))
    assert(whitePawns.getPieces(4).position.equals(Square.E2))
    assert(whitePawns.getPieces(5).position.equals(Square.F2))
    assert(whitePawns.getPieces(6).position.equals(Square.G2))
    assert(whitePawns.getPieces(7).position.equals(Square.H2))
  }
  info("white king")
  "Get Pieces on kings" should "return E1 and E8 respectively" in {
    Board.createDefaultBoard()
    val whiteKing: BitBoard = Board.getWhiteKing
    val blackKing: BitBoard = Board.getBlackKing
    assert(whiteKing.getPieces(0).position.equals(Square.E1))
    assert(blackKing.getPieces(0).position.equals(Square.E8))
  }
}

package board

import org.scalatest.FlatSpec

class BoardTest extends FlatSpec {


  info("white pawn positions tests")
  "Create Default Board" should "return default white pawn positions" in {
    Board.createDefaultBoard()
    val whitePawns: BitBoard = Board.getWhitePawns
    assert(whitePawns.binaryRepString.equals("0000000011111111000000000000000000000000000000000000000000000000"))
  }
  info("black pawn positions tests")
  "Create Default Board" should "return default black pawn positions" in {
    Board.createDefaultBoard()
    val whitePawns: BitBoard = Board.getBlackPawns
    assert(whitePawns.binaryRepString.equals("0000000000000000000000000000000000000000000000001111111100000000"))
  }
  info("white rook positions tests")
  "Create Default Board" should "return default white rook positions" in {
    Board.createDefaultBoard()
    val whitePawns: BitBoard = Board.getWhiteRooks
    assert(whitePawns.binaryRepString.equals("1000000100000000000000000000000000000000000000000000000000000000"))
  }
  info("black rook positions tests")
  "Create Default Board" should "return default black rook positions" in {
    val whitePawns: BitBoard = Board.getBlackRooks
    assert(whitePawns.binaryRepString.equals("0000000000000000000000000000000000000000000000000000000010000001"))
  }
  info("white knight positions tests")
  "Create Default Board" should "return default white knight positions" in {
    val whitePawns: BitBoard = Board.getWhiteKnights
    assert(whitePawns.binaryRepString.equals("0100001000000000000000000000000000000000000000000000000000000000"))
  }
  info("black knight positions tests")
  "Create Default Board" should "return default black knight positions" in {
    val whitePawns: BitBoard = Board.getBlackKnights
    assert(whitePawns.binaryRepString.equals("0000000000000000000000000000000000000000000000000000000001000010"))
  }
  info("white bishop positions tests")
  "Create Default Board" should "return default white bishop positions" in {
    val whitePawns: BitBoard = Board.getWhiteBishops
    assert(whitePawns.binaryRepString.equals("0010010000000000000000000000000000000000000000000000000000000000"))
  }
  info("black bishop positions tests")
  "Create Default Board" should "return default black bishop positions" in {
    val whitePawns: BitBoard = Board.getBlackBishops
    assert(whitePawns.binaryRepString.equals("0000000000000000000000000000000000000000000000000000000000100100"))
  }
  info("white queen positions tests")
  "Create Default Board" should "return default white queen positions" in {
    val whitePawns: BitBoard = Board.getWhiteQueens
    assert(whitePawns.binaryRepString.equals("0001000000000000000000000000000000000000000000000000000000000000"))
  }
  info("black queen positions tests")
  "Create Default Board" should "return default black queen positions" in {
    val whitePawns: BitBoard = Board.getBlackQueens
    assert(whitePawns.binaryRepString.equals("0000000000000000000000000000000000000000000000000000000000010000"))
  }

  info("white king positions tests")
  "Create Default Board" should "return default white king positions" in {
    val whitePawns: BitBoard = Board.getWhiteKing
    assert(whitePawns.binaryRepString.equals("0000100000000000000000000000000000000000000000000000000000000000"))
  }

  info("black king positions tests")
  "Create Default Board" should "return default black king positions" in {
    val whitePawns: BitBoard = Board.getBlackKing
    assert(whitePawns.binaryRepString.equals("0000000000000000000000000000000000000000000000000000000000001000"))
  }

  info("default white pieces positions")
  "After Create Default Board getAllWhitePiecesBinaryRep" should "return 0xFFFF000000000000L" in {
    assert(Board.getAllWhitePiecesBinaryRep.equals(0xFFFF000000000000L))
  }

  info("default black pieces positions")
  "After Create Default Board getAllBlackPiecesBinaryRep" should "return 0x000000000000FFFFL" in {
    assert(Board.getAllBlackPiecesBinaryRep.equals(0x000000000000FFFFL))
  }


}

package piece

import board.Square
import org.scalatest.FlatSpec

class PieceTest extends FlatSpec {
  info("Piece Test")
  "White Pawn on A1" should "be white and on square A1" in {
    val whitePawn = WhitePawn(Square.A1)

    assert(whitePawn.pieceCode == PieceCode.wpawn)
    assert(whitePawn.getPieceCode == PieceCode.wpawn)
    assert(!whitePawn.isBlack)
    assert(whitePawn.isWhite)
    assert(whitePawn.position == Square.A1)
    assert(whitePawn.getPosition == Square.A1)
  }
}

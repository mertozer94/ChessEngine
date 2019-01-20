package lookup

import board.Square
import org.scalatest.FlatSpec

class PieceLookupTest extends FlatSpec {
  info("Piece lookup tests")
  "PieceLookup on square H8" should "return 0x0000000000000001L" in {
    assert(PieceLookup.value(Square.H8).equals(0x0000000000000001L))
  }
  "PieceLookup on square D3" should "return 0x0000100000000000L" in {
    assert(PieceLookup.value(Square.D3).equals(0x0000100000000000L))
  }
  "PieceLookup on square A1" should "return 0x8000000000000000L" in {
    assert(PieceLookup.value(Square.A1).equals(0x8000000000000000L))
  }

}

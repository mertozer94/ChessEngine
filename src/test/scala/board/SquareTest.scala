package board

import org.scalatest.FlatSpec

class SquareTest extends FlatSpec {
  info("squareToInt tests")
  "Square C1 to Int" should "return 0" in {
    assert(Square.squareToInt(Square.A1) == 0)
  }
  "Square C1 to Int" should "return  63" in {
    assert(Square.squareToInt(Square.H8) == 63)
  }
  info("getCoordinates tests")
  "Square C1 coordinates" should "return (0, 2)" in {
    assert(Square.getCoordinates(Square.C1) == (0, 2))
  }
  "Square A1 coordinates" should "return (0, 0)" in {
    assert(Square.getCoordinates(Square.A1) == (0, 0))
  }
  "Square H8 coordinates" should "return (7, 7)" in {
    assert(Square.getCoordinates(Square.H8) == (7, 7))
  }
  "Square B6 coordinates" should "return (0, 2)" in {
    assert(Square.getCoordinates(Square.B6) == (5, 1))
  }
  info("getSquareFromId tests")
  "getSquareFromId 1" should "return A1" in {
    assert(Square.getSquareFromId(0) == Square.A1)
  }
  "getSquareFromId 63" should "return H8" in {
    assert(Square.getSquareFromId(63) == Square.H8)
  }
  info("getSquareFromCoordinates tests")
  "getSquareFromCoordinates (0,0)" should "return A1" in {
    assert(Square.getSquareFromCoordinates(0, 0) == Square.A1)
  }
  "getSquareFromCoordinates (7,7)" should "return H8" in {
    assert(Square.getSquareFromCoordinates(7, 7) == Square.H8)
  }
  "getSquareFromCoordinates (4,5)" should "return F5" in {
    assert(Square.getSquareFromCoordinates(4, 5) == Square.F5)
  }
  info("getSymmetricSquare tests")
  "getSymmetricSquare A1" should "return A8" in {
    assert(Square.getSymmetricSquare(Square.A1) == Square.A8)
  }
  "getSymmetricSquare A8" should "return A1" in {
    assert(Square.getSymmetricSquare(Square.A8) == Square.A1)
  }
  info("getSymmetricSquare tests")
  "getSymmetricSquare B4" should "return B5" in {
    assert(Square.getSymmetricSquare(Square.B4) == Square.B5)
  }
  "getSymmetricSquare B5" should "return B4" in {
    assert(Square.getSymmetricSquare(Square.B5) == Square.B4)
  }
}

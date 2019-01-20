package game

import piece.Piece

object PlayedMoves {
  private val moves: List[(String, Piece)] = List()

  def getLastMove: (String, Piece) = {
    moves.last
  } // TODO NoSuchElementException possible,
  //  def takeBackLastMove
}

package game

import piece.Piece

object PlayedMoves {
  private val moves: List[(String, Piece)] = List()

  def getLastMove: (String, Piece) = {
      moves.last
  }
  def getLengthOfMoves : Int = {moves.length}

//  TODO complete function
//  def takeBackLastMove = {}
}
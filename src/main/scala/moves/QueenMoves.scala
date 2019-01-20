package moves

import piece.Piece

object QueenMoves {
  def generateMoves(piece: Piece, ownSide: Long, otherSide: Long): Long = {
    BishopMoves.generateMoves(piece, ownSide, otherSide) | RookMoves.generateMoves(piece, ownSide, otherSide)
  }
}

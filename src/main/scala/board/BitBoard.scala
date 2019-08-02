package board

import board.Square.Square
import piece.Piece

case class BitBoard() {
  val bitBoard: Array[Array[Piece]] = Array.ofDim[Piece](8, 8)

  def getPieces: Array[Piece] = {
    bitBoard.flatMap(row => row.map(piece => piece)).filter(piece => piece != null)
  }

  def getPieceOn(square: Square): Option[Piece] = {
    getPieces.find(_.getPosition.equals(square))
  }

  def binaryRep: Long = BigInt(binaryRepString, 2).longValue()

  def printBoard(): Unit = print(binaryRepString)

  def binaryRepString: String = bitBoard.flatMap(row => row.map(piece => if (piece == null) "0" else "1")).mkString("")

  def addPiece(piece: Piece): Unit = {
    val (x, y) = Square.getCoordinates(piece.getPosition)
    bitBoard(x)(y) = piece
  }
}

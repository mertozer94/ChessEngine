package piece

import board.Square.Square

abstract class Piece {
  val pieceCode: Int

  val position: Square

  var previousPositions = List()

  def getPieceCode: Int = pieceCode

  def isWhite: Boolean = pieceCode < 8

  def isBlack: Boolean = !isWhite

  def getPosition: Square = position

  def getLastPosition: Square = previousPositions.last

}

case class WhitePawn(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wpawn
}

case class WhiteKnight(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wknight
}

case class WhiteBishop(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wbishop
}

case class WhiteRook(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wrook
}

case class WhiteQueen(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wqueen
}

case class WhiteKing(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wking
  var canCastle: Boolean = true
}

case class BlackPawn(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.bpawn
}

case class BlackKnight(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.bknight
}

case class BlackBishop(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.bbishop
}

case class BlackRook(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.brook
}

case class BlackQueen(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.bqueen
}

case class BlackKing(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.bking
  var canCastle: Boolean = true
}

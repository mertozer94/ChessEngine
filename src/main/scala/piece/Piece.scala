package piece

import board.Square.Square

abstract class Piece {

  val pieceCode: Int

  val pieceAbbreviation: String

  val position: Square

  val previousPositions = List()

  def getPieceCode: Int = pieceCode

  def isWhite: Boolean = pieceCode < 8

  def isBlack: Boolean = !isWhite

  def getPosition: Square = position

  def getLastPosition: Square = previousPositions.last

  var canCastle: Boolean
}

case class WhitePawn(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wpawn
  val pieceAbbreviation: String = "P"
  var canCastle: Boolean = false
}

case class WhiteKnight(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wknight
  val pieceAbbreviation: String = "N"
  var canCastle: Boolean = false
}

case class WhiteBishop(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wbishop
  val pieceAbbreviation: String = "B"
  var canCastle: Boolean = false
}

case class WhiteRook(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wrook
  val pieceAbbreviation: String = "R"
  var canCastle: Boolean = false
}

case class WhiteQueen(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wqueen
  val pieceAbbreviation: String = "Q"
  var canCastle: Boolean = false

}

case class WhiteKing(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.wking
  val pieceAbbreviation: String = "K"
  var canCastle: Boolean = true
}

case class BlackPawn(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.bpawn
  val pieceAbbreviation: String = "p"
  var canCastle: Boolean = false

}

case class BlackKnight(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.bknight
  val pieceAbbreviation: String = "n"
  var canCastle: Boolean = false

}

case class BlackBishop(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.bbishop
  val pieceAbbreviation: String = "b"
  var canCastle: Boolean = false

}

case class BlackRook(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.brook
  val pieceAbbreviation: String = "r"
  var canCastle: Boolean = false

}

case class BlackQueen(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.bqueen
  val pieceAbbreviation: String = "q"
  var canCastle: Boolean = false
}

case class BlackKing(position: Square) extends Piece {
  val pieceCode: Int = PieceCode.bking
  val pieceAbbreviation: String = "k"
  var canCastle: Boolean = true
}

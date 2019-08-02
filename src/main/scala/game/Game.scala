package game

import board.Board
import engine.Engine

import scala.io.StdIn

object Game {

  def makeMove(move:String): Unit = {

  }
  def proposeMoves(color:Int): Unit = {
    val a = color % 2 match  {
      case 0 => Board.getWhitePieces
      case _ => Board.getBlackPieces
    }

//    a.values.map(bitboard => bitboard.getPieces.map(piece => println("piece = " + piece.pieceAbbreviation + "\n" + Engine.generateMovesForGivenPiece(piece))))
    a.values.map(bitboard => bitboard.getPieces.map(piece => println(
      "piece = " + piece.pieceAbbreviation +
      " on square = (" + piece.position + ")" +
      "\n" + printMovesInATableRepresentation( Engine.generateMovesForGivenPiece(piece)))))
    val ln = StdIn.readLine()

  }

  def printMovesInATableRepresentation(possibleMoves: Long): String = {
    val representation:String = String.format("%64s", possibleMoves.toBinaryString).replace(' ', '0')

    val toPrint =  new StringBuilder

    (7 to 0 by -1).toArray.foreach(row => {
      (0 to 7).toArray.foreach(col => {
        val squareId = row * 8 + col
        toPrint.append(representation.charAt(squareId))
        toPrint.append(" ")
        if (col == 7)
          toPrint.append("\n")
      })
    })
    toPrint.toString()
  }
}

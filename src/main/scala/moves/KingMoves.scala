package moves

import board.Square
import lookup.{ClearFile, PieceLookup}
import piece.Piece

object KingMoves {

  // spots
  /* 6    7    8
  *  4    x    5
  *  1    2    3
  * */
  def generateMoves(piece: Piece, ownSide: Long, otherSide: Long): Long = {
    val kingLocation: Long = PieceLookup.value(piece.position)
    val kingClipFileH = kingLocation & ClearFile.FILE_H
    val kingClipFileA = kingLocation & ClearFile.FILE_A

    val spot1 = kingClipFileA << 9
    val spot2 = kingLocation << 8
    val spot3 = kingClipFileH << 7
    val spot4 = kingLocation << 1
    val spot5 = kingLocation >>> 1
    val spot6 = kingClipFileA >>> 7
    val spot7 = kingLocation >>> 8
    val spot8 = kingClipFileH >>> 9

    val kingMoves = spot1 | spot2 | spot3 | spot4 | spot5 | spot6 | spot7 | spot8

    val validMoves = kingMoves & ~ownSide
    validMoves
  }

  // TODO add rook!!
  // TODO check if can castle
  // TODO test short rook
  def shortRook(piece: Piece, ownSide: Long, otherSide: Long): Long = {
    var f = 0L
    var g = 0L
    if (piece.isWhite) {
      f = PieceLookup.value(Square.F1)
      g = PieceLookup.value(Square.G1)
    }
    else {
      f = PieceLookup.value(Square.F8)
      g = PieceLookup.value(Square.G8)
    }
    if (((g & ownSide & otherSide) == 0x0L) & ((f & ownSide & otherSide) == 0x0L))
      g

    0x0L
  }

  // TODO add rook!!
  // TODO check if can castle
  // TODO test big rook
  def bigRook(piece: Piece, ownSide: Long, otherSide: Long): Long = {
    var b = 0L
    var c = 0L
    var d = 0L

    if (piece.isWhite) {
      b = PieceLookup.value(Square.B1)
      c = PieceLookup.value(Square.C1)
      d = PieceLookup.value(Square.D1)

    }
    else {
      b = PieceLookup.value(Square.B8)
      c = PieceLookup.value(Square.C8)
      d = PieceLookup.value(Square.D8)
    }
    if (((b & ownSide & otherSide) == 0x0L) & ((c & ownSide & otherSide) == 0x0L) & ((d & ownSide & otherSide) == 0x0L))
      c

    0x0L
  }
}

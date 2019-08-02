package moves

import lookup.{ClearFile, PieceLookup}
import piece.Piece

/* spots
  *
  *   2   3
  * 1        4
  *     x
  * 8        5
  *   7   6
  *
  */
object KnightMoves {
  def generateMoves(piece: Piece, ownSide: Long): Long = {
    val knightLocation: Long = PieceLookup.value(piece.position)
    val knightClipFileH = knightLocation & ClearFile.FILE_H
    val knightClipFileA = knightLocation & ClearFile.FILE_A
    val knightClipFileG = knightLocation & ClearFile.FILE_G
    val knightClipFileB = knightLocation & ClearFile.FILE_B

    val spot1 = (knightClipFileA & knightClipFileB) >>> 6
    val spot2 = knightClipFileA >>> 15
    val spot3 = knightClipFileH >>> 17
    val spot4 = (knightClipFileG & knightClipFileH) >>> 10

    val spot5 = (knightClipFileH & knightClipFileG) << 6
    val spot6 = knightClipFileH << 15
    val spot7 = knightClipFileA << 17
    val spot8 = (knightClipFileA & knightClipFileB) << 10

    val knightMoves = spot1 | spot2 | spot3 | spot4 | spot5 | spot6 | spot7 | spot8

    val validMoves = knightMoves & ~ownSide
    validMoves
  }
}

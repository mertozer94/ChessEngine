package moves

import board.{Board, Square}
import lookup.{ClearFile, PieceLookup}
import piece.Piece

object KingMoves {

  // spots
  /* 6    7    8
  *  4    x    5
  *  1    2    3
  * */
  def generateMoves(piece: Piece, ownSide: Long, otherSide: Long): Long = {

    def getRookMoves: Long = {

      def shortRook(): Long = {
        var f = 0L
        var g = 0L
        // if can castle
        if (piece.canCastle) {
          //if it is a white king
          if (piece.isWhite) {

            Board.getWhitePieceOnSquare(Square.H1) match {
              case Some(pieceOnH1) => {
                // if there is a white rook on h1
                if (pieceOnH1.getPieceCode == 5) {

                  // if kings position is e1
                  if (piece.position.equals(Square.E1)) {
                    f = PieceLookup.value(Square.F1)
                    g = PieceLookup.value(Square.G1)
                  }
                }
              }
              case None => return 0L
            }
          }
          else {
            Board.getBlackPieceOnSquare(Square.H8) match {
              case Some(pieceOnH8) => {
                if (pieceOnH8.getPieceCode == 13) {
                  if (piece.position.equals(Square.E8)) {
                    f = PieceLookup.value(Square.F8)
                    g = PieceLookup.value(Square.G8)
                  }
                }
              }
              case None => return 0L

            }
          }

          if (((g & ownSide) == 0x0L) & ((g & otherSide) == 0x0L) & ((f & ownSide) == 0x0L) & ((f & otherSide) == 0x0L))
            g
          else 0x0L
        }
        else
          0x0L
      }

      def bigRook(): Long = {
        var b = 0L
        var c = 0L
        var d = 0L

        if (piece.canCastle) {
          if (piece.isWhite) {
            Board.getWhitePieceOnSquare(Square.A1) match {
              case Some(pieceOnA1) => {
                // if there is a white rook on a1
                if (pieceOnA1.getPieceCode == 5) {

                  // if kings position is e1
                  if (piece.position.equals(Square.E1)) {
                    b = PieceLookup.value(Square.B1)
                    c = PieceLookup.value(Square.C1)
                    d = PieceLookup.value(Square.D1)
                  }
                }
              }
              case None => 0x0L

            }

          }
          else {
            Board.getBlackPieceOnSquare(Square.A8) match {
              case Some(pieceOnA8) => {
                if (pieceOnA8.getPieceCode == 13) {
                  if (piece.position.equals(Square.E8)) {
                    b = PieceLookup.value(Square.B8)
                    c = PieceLookup.value(Square.C8)
                    d = PieceLookup.value(Square.D8)
                  }
                }
              }
              case None => 0x0L

            }
          }
          if (((b & ownSide) == 0x0L) & ((b & otherSide) == 0x0L) & ((c & ownSide) == 0x0L) & ((c & otherSide) == 0x0L) & ((d & ownSide) == 0x0L) & ((d & otherSide) == 0x0L))
            c
          else 0x0L
        }
        else
        0x0L
      }

      shortRook() | bigRook()
    }

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
    val castleMoves = getRookMoves
    validMoves | castleMoves

  }

}

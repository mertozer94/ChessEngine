package moves

import game.PlayedMoves
import lookup.{ClearFile, MaskRank, PieceLookup}
import piece.Piece


/*
*       twoStep
* left  oneStep   right
*          x
*
*/
object WhitePawnMoves {
  def generateMoves(piece: Piece, ownSide: Long, otherSide: Long): Long = {
    val pawnLocation: Long = PieceLookup.value(piece.position)
    val oneStep = (pawnLocation >>> 8) & ~ownSide & ~otherSide
    val twoStep = ((oneStep & MaskRank.RANK_3) >>> 8) & ~ownSide & ~otherSide
    val left = ((pawnLocation & ClearFile.FILE_A) >>> 7) & otherSide
    val right = ((pawnLocation & ClearFile.FILE_H) >>> 9) & otherSide
    val possibleMoves = oneStep | twoStep | left | right
    possibleMoves
  }

  // TODO test cases for en passant
  def generateEnPassantMoves(piece: Piece): Long = {
    val myPosition = PieceLookup.value(piece.getPosition)
    val lastMoveString = PlayedMoves.getLastMove._1
    val lastPlayedBlackPiece = PlayedMoves.getLastMove._2

    val firstPlace: Long = PieceLookup.value(lastPlayedBlackPiece.getLastPosition)
    val secondPlace: Long = PieceLookup.value(lastPlayedBlackPiece.position)

    //if my pawn is on my 5th rank
    if ((myPosition & MaskRank.RANK_6) == myPosition) {
      // if last piece was a white pawn
      if (lastPlayedBlackPiece.pieceCode == 1) {
        // if last move was a not promotion
        if (lastMoveString.length == 4) {
          // if it was a two step move
          if (java.lang.Long.bitCount(firstPlace ^ secondPlace) == 2) {
            // white pawn should be next to the black pawn
            if ((((myPosition >>> 1) == secondPlace) || ((myPosition << 1) == secondPlace))) {
              secondPlace << 8
            }
          }
        }
      }
    }
    0x0L
  }
}

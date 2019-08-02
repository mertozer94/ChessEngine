package moves

import game.PlayedMoves
import lookup.{ClearFile, MaskRank, PieceLookup}
import piece.Piece

/*
*         x
*
* right  oneStep   left
*
*       twoStep
*
*/
object BlackPawnMoves {
  def generateMoves(piece: Piece, ownSide: Long, otherSide: Long): Long = {
    // TODO test cases for en passant
    def generateEnPassantMoves: Long = {
      val myPosition = PieceLookup.value(piece.getPosition)
      if (PlayedMoves.getLengthOfMoves != 0) {
        val lastMoveString = PlayedMoves.getLastMove._1
        val lastPlayedWhitePiece = PlayedMoves.getLastMove._2

        val firstPlace: Long = PieceLookup.value(lastPlayedWhitePiece.getLastPosition)
        val secondPlace: Long = PieceLookup.value(lastPlayedWhitePiece.position)


        //if my pawn is on my 5th rank
        if ((myPosition & MaskRank.RANK_4) == myPosition) {
          // if last piece was a black pawn
          if (lastPlayedWhitePiece.pieceCode == 10) {
            // if last move was a not promotion
            if (lastMoveString.length == 4) {
              // if it was a two step move
              if (java.lang.Long.bitCount(firstPlace ^ secondPlace) == 2) {
                // white pawn should be next to the black pawn
                if ((((myPosition >>> 1) == secondPlace) || ((myPosition << 1) == secondPlace))) {
                  secondPlace >>> 8
                }
              }
            }
          }
        }
      }
      0x0L
    }

    val pawnLocation: Long = PieceLookup.value(piece.position)
    val oneStep = (pawnLocation << 8) & ~ownSide & ~otherSide
    val twoStep = ((oneStep & MaskRank.RANK_6) << 8) & ~ownSide & ~otherSide
    val left = ((pawnLocation & ClearFile.FILE_H) << 7) & otherSide
    val right = ((pawnLocation & ClearFile.FILE_A) << 9) & otherSide
    val possibleMoves = oneStep | twoStep | left | right | generateEnPassantMoves
    possibleMoves


  }


}

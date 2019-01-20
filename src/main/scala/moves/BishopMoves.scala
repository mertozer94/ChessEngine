package moves

import lookup.{ClearFile, PieceLookup}
import piece.Piece

/*
*    spots1         spots2
*
*              x
*
*    spots4         spots3
*
* */

object BishopMoves {
  def generateMoves(piece: Piece, ownSide: Long, otherSide: Long): Long = {
    def createSpots1(piece: Piece, ownSide: Long, otherSide: Long): Long = {
      def helper(newLocation: Long, result: Long): Long = {
        if (newLocation == -1L || newLocation == 0L || newLocation == (newLocation & ownSide))
          result
        else if (newLocation == (newLocation & otherSide))
          result | newLocation
        else
          helper((newLocation & ClearFile.FILE_A) >>> 7, result | newLocation)
      }

      val rookPosition = PieceLookup.value(piece.getPosition)
      helper((rookPosition & ClearFile.FILE_A) >>> 7, 0x0L)
    }

    def createSpots2(piece: Piece, ownSide: Long, otherSide: Long): Long = {
      def helper(newLocation: Long, result: Long): Long = {
        if (newLocation == -1L || newLocation == 0L || newLocation == (newLocation & ownSide))
          result
        else if (newLocation == (newLocation & otherSide))
          result | newLocation
        else
          helper((newLocation & ClearFile.FILE_H) >>> 9, result | newLocation)
      }

      val rookPosition = PieceLookup.value(piece.getPosition)
      helper((rookPosition & ClearFile.FILE_H) >>> 9, 0x0L)
    }

    def createSpots3(piece: Piece, ownSide: Long, otherSide: Long): Long = {
      def helper(newLocation: Long, result: Long): Long = {
        if (newLocation == -1L || newLocation == 0L || newLocation == (newLocation & ownSide))
          result
        else if (newLocation == (newLocation & otherSide))
          result | newLocation
        else
          helper((newLocation & ClearFile.FILE_H) << 7, result | newLocation)
      }

      val rookPosition = PieceLookup.value(piece.getPosition)
      helper((rookPosition & ClearFile.FILE_H) << 7, 0x0L)
    }

    def createSpots4(piece: Piece, ownSide: Long, otherSide: Long): Long = {
      def helper(newLocation: Long, result: Long): Long = {
        if (newLocation == -1L || newLocation == 0L || newLocation == (newLocation & ownSide))
          result
        else if (newLocation == (newLocation & otherSide))
          result | newLocation
        else
          helper((newLocation & ClearFile.FILE_A) << 9, result | newLocation)
      }

      val rookPosition = PieceLookup.value(piece.getPosition)
      helper((rookPosition & ClearFile.FILE_A) << 9, 0x0L)
    }

    val spot1 = createSpots1(piece, ownSide, otherSide)
    val spot2 = createSpots2(piece, ownSide, otherSide)
    val spot3 = createSpots3(piece, ownSide, otherSide)
    val spot4 = createSpots4(piece, ownSide, otherSide)
    spot1 | spot2 | spot3 | spot4
  }
}

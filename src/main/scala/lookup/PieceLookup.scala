package lookup

import board.Square.Square

object PieceLookup {
  def value(square: Square): Long = {
    val firstPosition: Long = 0x8000000000000000L

    def getValue(i: Int, result: Long): Long = {
      if (i == 0) result
      else getValue(i - 1, result >>> 1)
    }

    getValue(square.id, firstPosition)

  }

}

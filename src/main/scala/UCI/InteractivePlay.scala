package UCI

import board.Board
import game.Game

import scala.io.StdIn

object InteractivePlay {

  def main(args: Array[String]): Unit = {
    Board.createDefaultBoard()
    communication()
  }
  def communication() {
    var a = 0
    while (true) {
      val ln = StdIn.readLine()
      Game.proposeMoves(a)
      a += 1
    }
  }

}

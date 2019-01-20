package UCI

import scala.io._

class UCI {
  val engine = "v1"
  val author = "Mert Ozer"

  def communication() {
    while (true) {
      val ln = StdIn.readLine()

      ln match {
        case "uci" => uciInput()
        case "isready" => isReadyInput()
        case "setoption" => setOptionInput()
        case "ucinewgame" => newGameInput()
        case "go" => null
        case "quit" => println("quit")
      }
    }
  }


  def uciInput(): Unit = {
    println("id name " + engine)
    println("id author " + author)
    println("uciok")
  }

  def isReadyInput(): Unit = {
    println("readyok")
  }

  def setOptionInput() = {}

  def newGameInput() = {}

  def goInput() = {}


}
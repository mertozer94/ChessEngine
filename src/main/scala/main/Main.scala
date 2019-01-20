package main

import UCI.UCI

object Main {
  def main(args: Array[String]): Unit = {
    val obj = new UCI()
    obj.communication()
  }
}

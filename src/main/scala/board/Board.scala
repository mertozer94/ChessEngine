package board

import piece._

import scala.collection.mutable


object Board {
  val pieces: Array[mutable.HashMap[String, BitBoard]] = new Array[mutable.HashMap[String, BitBoard]](2)

  def getWhitePieces: mutable.HashMap[String, BitBoard] = {
    pieces(0)
  }

  def getBlackPieces: mutable.HashMap[String, BitBoard] = {
    pieces(1)
  }

  def getAllWhitePiecesBinaryRep: Long = {
    getWhitePawns.binaryRep | getWhiteRooks.binaryRep | getWhiteKnights.binaryRep | getWhiteBishops.binaryRep | getWhiteQueens.binaryRep | getWhiteKing.binaryRep
  }

  def getAllBlackPiecesBinaryRep: Long = {
    getBlackPawns.binaryRep | getBlackRooks.binaryRep | getBlackKnights.binaryRep | getBlackBishops.binaryRep | getBlackQueens.binaryRep | getBlackKing.binaryRep
  }

  def getWhitePawns: BitBoard = {
    getWhitePieces("pawn")
  }

  def getWhiteRooks: BitBoard = {
    getWhitePieces("rook")
  }

  def getWhiteKnights: BitBoard = {
    getWhitePieces("knight")
  }

  def getWhiteBishops: BitBoard = {
    getWhitePieces("bishop")
  }

  def getWhiteQueens: BitBoard = {
    getWhitePieces("queen")
  }

  def getWhiteKing: BitBoard = {
    getWhitePieces("king")
  }

  def getBlackPawns: BitBoard = {
    getBlackPieces("pawn")
  }

  def getBlackRooks: BitBoard = {
    getBlackPieces("rook")
  }

  def getBlackKnights: BitBoard = {
    getBlackPieces("knight")
  }

  def getBlackBishops: BitBoard = {
    getBlackPieces("bishop")
  }

  def getBlackQueens: BitBoard = {
    getBlackPieces("queen")
  }

  def getBlackKing: BitBoard = {
    getBlackPieces("king")
  }


  def createDefaultBoard(): Array[mutable.HashMap[String, BitBoard]] = {

    var whitePieces = new mutable.HashMap[String, BitBoard]
    var blackPieces = new mutable.HashMap[String, BitBoard]
    createDefaultPawns()
    createDefaultRooks()
    createDefaultKnights()
    createDefaultBishops()
    createDefaultQueen()
    createDefaultKing()

    def createDefaultPawns(): Unit = {
      val whitePawns = BitBoard()
      val blackPawns = BitBoard()
      (8 until 16).toArray.foreach(number => {
        val wSquare = Square.getSquareFromId(number)
        val bSquare = Square.getSymmetricSquare(wSquare)
        val whitePiece = WhitePawn(wSquare)
        val blackPiece = BlackPawn(bSquare)
        whitePawns.addPiece(whitePiece)
        blackPawns.addPiece(blackPiece)
      })
      val wMap = "pawn" -> whitePawns
      val bMap = "pawn" -> blackPawns
      whitePieces += wMap
      blackPieces += bMap
    }

    def createDefaultRooks(): Unit = {
      val whiteRooks = BitBoard()
      val blackRooks = BitBoard()
      Array(0, 7).foreach(number => {
        val wSquare = Square.getSquareFromId(number)
        val bSquare = Square.getSymmetricSquare(wSquare)
        val whitePiece = WhiteRook(wSquare)
        val blackPiece = BlackRook(bSquare)
        whiteRooks.addPiece(whitePiece)
        blackRooks.addPiece(blackPiece)
      })
      val wMap = "rook" -> whiteRooks
      val bMap = "rook" -> blackRooks
      whitePieces += wMap
      blackPieces += bMap
    }

    def createDefaultKnights(): Unit = {
      val whiteKnights = BitBoard()
      val blackKnights = BitBoard()
      Array(1, 6).foreach(number => {
        val wSquare = Square.getSquareFromId(number)
        val bSquare = Square.getSymmetricSquare(wSquare)
        val whitePiece = WhiteKnight(wSquare)
        val blackPiece = BlackKnight(bSquare)
        whiteKnights.addPiece(whitePiece)
        blackKnights.addPiece(blackPiece)
      })
      val wMap = "knight" -> whiteKnights
      val bMap = "knight" -> blackKnights
      whitePieces += wMap
      blackPieces += bMap
    }

    def createDefaultBishops(): Unit = {
      val whiteBishops = BitBoard()
      val blackBishops = BitBoard()
      Array(2, 5).foreach(number => {
        val wSquare = Square.getSquareFromId(number)
        val bSquare = Square.getSymmetricSquare(wSquare)
        val whitePiece = WhiteBishop(wSquare)
        val blackPiece = BlackBishop(bSquare)
        whiteBishops.addPiece(whitePiece)
        blackBishops.addPiece(blackPiece)
      })
      val wMap = "bishop" -> whiteBishops
      val bMap = "bishop" -> blackBishops
      whitePieces += wMap
      blackPieces += bMap
    }

    def createDefaultQueen(): Unit = {

      val whiteQueens = BitBoard()
      val blackQueens = BitBoard()
      Array(3).foreach(number => {
        val wSquare = Square.getSquareFromId(number)
        val bSquare = Square.getSymmetricSquare(wSquare)
        val whitePiece = WhiteQueen(wSquare)
        val blackPiece = BlackQueen(bSquare)
        whiteQueens.addPiece(whitePiece)
        blackQueens.addPiece(blackPiece)
      })
      val wMap = "queen" -> whiteQueens
      val bMap = "queen" -> blackQueens
      whitePieces += wMap
      blackPieces += bMap
    }

    def createDefaultKing(): Unit = {
      val whiteKing = BitBoard()
      val blackKing = BitBoard()
      Array(4).foreach(number => {
        val wSquare = Square.getSquareFromId(number)
        val bSquare = Square.getSymmetricSquare(wSquare)
        val whitePiece = WhiteKing(wSquare)
        val blackPiece = BlackKing(bSquare)
        whiteKing.addPiece(whitePiece)
        blackKing.addPiece(blackPiece)
      })
      val wMap = "king" -> whiteKing
      val bMap = "king" -> blackKing
      whitePieces += wMap
      blackPieces += bMap
    }

    pieces(0) = whitePieces
    pieces(1) = blackPieces
    pieces
  }

}
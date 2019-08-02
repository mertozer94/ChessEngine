package board

import board.Square.Square
import piece._

import scala.collection.mutable


object Board {
  val pieces: Array[mutable.HashMap[Int, BitBoard]] = new Array[mutable.HashMap[Int, BitBoard]](2)

  def getPieceOnSquare(square: Square): Option[Piece] = {

    getBlackPieceOnSquare(square) match {
      case Some(piece) => {
        Some(piece)
      }
      case None => getWhitePieceOnSquare(square) match {
        case Some(piece) => {
          Some(piece)
        }
        case None => None
      }
    }
  }

  def getWhitePieceOnSquare(square: Square): Option[Piece] = {
    getWhitePieces.values.toArray.find(bitBoard => bitBoard.getPieceOn(square).isDefined) match {
      case Some(board) => board.getPieceOn(square)
      case None => None
    }
  }

  def getBlackPieceOnSquare(square: Square): Option[Piece] = {
    getBlackPieces.values.toArray.find(bitBoard => bitBoard.getPieceOn(square).isDefined) match {
      case Some(board) => board.getPieceOn(square)
      case None => None
    }
  }

  def getWhitePieces: mutable.HashMap[Int, BitBoard] = {
    pieces(0)
  }

  def getBlackPieces: mutable.HashMap[Int, BitBoard] = {
    pieces(1)
  }

  def getAllWhitePiecesBinaryRep: Long = {
    getWhitePawns.binaryRep | getWhiteRooks.binaryRep | getWhiteKnights.binaryRep | getWhiteBishops.binaryRep | getWhiteQueens.binaryRep | getWhiteKing.binaryRep
  }

  def getAllBlackPiecesBinaryRep: Long = {
    getBlackPawns.binaryRep | getBlackRooks.binaryRep | getBlackKnights.binaryRep | getBlackBishops.binaryRep | getBlackQueens.binaryRep | getBlackKing.binaryRep
  }

  def getWhitePawns: BitBoard = {
    getWhitePieces(PieceCode.wpawn)
  }

  def getWhiteRooks: BitBoard = {
    getWhitePieces(PieceCode.wrook)
  }

  def getWhiteKnights: BitBoard = {
    getWhitePieces(PieceCode.wknight)
  }

  def getWhiteBishops: BitBoard = {
    getWhitePieces(PieceCode.wbishop)
  }

  def getWhiteQueens: BitBoard = {
    getWhitePieces(PieceCode.wqueen)
  }

  def getWhiteKing: BitBoard = {
    getWhitePieces(PieceCode.wking)
  }

  def getBlackPawns: BitBoard = {
    getBlackPieces(PieceCode.bpawn)
  }

  def getBlackRooks: BitBoard = {
    getBlackPieces(PieceCode.brook)
  }

  def getBlackKnights: BitBoard = {
    getBlackPieces(PieceCode.bknight)
  }

  def getBlackBishops: BitBoard = {
    getBlackPieces(PieceCode.bbishop)
  }

  def getBlackQueens: BitBoard = {
    getBlackPieces(PieceCode.bqueen)
  }

  def getBlackKing: BitBoard = {
    getBlackPieces(PieceCode.bking)
  }

  def boardRepresentation: String = {
    val representation =  new StringBuilder
    (7 to 0 by -1).toArray.foreach(row => {
      (0 to 7).toArray.foreach(col => {
        val squareId = row * 8 + col
        val square = Square.getSquareFromId(squareId)
        getPieceOnSquare(square) match {
          case Some(piece) => representation.append(piece.pieceAbbreviation)
          case None => representation.append("-")
        }
        representation.append(" ")
        if (col == 7)
          representation.append("\n")
      })
    })
    representation.toString()
  }

  def printBoard: Unit = {print(boardRepresentation)}

  def createDefaultBoard(): Array[mutable.HashMap[Int, BitBoard]] = {

    var whitePieces = new mutable.HashMap[Int, BitBoard]
    var blackPieces = new mutable.HashMap[Int, BitBoard]
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
      val wMap = PieceCode.wpawn -> whitePawns
      val bMap = PieceCode.bpawn -> blackPawns
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
      val wMap = PieceCode.wrook -> whiteRooks
      val bMap = PieceCode.brook -> blackRooks
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
      val wMap = PieceCode.wknight -> whiteKnights
      val bMap = PieceCode.bknight -> blackKnights
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
      val wMap = PieceCode.wbishop -> whiteBishops
      val bMap = PieceCode.bbishop -> blackBishops
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
      val wMap = PieceCode.wqueen -> whiteQueens
      val bMap = PieceCode.bqueen -> blackQueens
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
      val wMap = PieceCode.wking -> whiteKing
      val bMap = PieceCode.bking -> blackKing
      whitePieces += wMap
      blackPieces += bMap
    }

    pieces(0) = whitePieces
    pieces(1) = blackPieces
    pieces
  }

}
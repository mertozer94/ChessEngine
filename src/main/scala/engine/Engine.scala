package engine

import board.Board
import moves._
import piece._


// TODO generate legal moves
object Engine {
  def generateMovesForGivenPiece(piece: Piece): Long = {
    piece match {
      case _: WhitePawn => WhitePawnMoves.generateMoves(piece, Board.getAllWhitePiecesBinaryRep, Board.getAllBlackPiecesBinaryRep)
      case _: WhiteRook => RookMoves.generateMoves(piece, Board.getAllWhitePiecesBinaryRep, Board.getAllBlackPiecesBinaryRep)
      case _: WhiteKnight => KnightMoves.generateMoves(piece, Board.getAllWhitePiecesBinaryRep)
      case _: WhiteBishop => BishopMoves.generateMoves(piece, Board.getAllWhitePiecesBinaryRep, Board.getAllBlackPiecesBinaryRep)
      case _: WhiteKing => KingMoves.generateMoves(piece, Board.getAllWhitePiecesBinaryRep, Board.getAllBlackPiecesBinaryRep)
      case _: WhiteQueen => QueenMoves.generateMoves(piece, Board.getAllWhitePiecesBinaryRep, Board.getAllBlackPiecesBinaryRep)

      case _: BlackPawn => BlackPawnMoves.generateMoves(piece, Board.getAllBlackPiecesBinaryRep, Board.getAllWhitePiecesBinaryRep)
      case _: BlackRook => RookMoves.generateMoves(piece, Board.getAllBlackPiecesBinaryRep, Board.getAllWhitePiecesBinaryRep)
      case _: BlackKnight => KnightMoves.generateMoves(piece, Board.getAllBlackPiecesBinaryRep)
      case _: BlackBishop => BishopMoves.generateMoves(piece, Board.getAllBlackPiecesBinaryRep, Board.getAllWhitePiecesBinaryRep)
      case _: BlackKing => KingMoves.generateMoves(piece, Board.getAllBlackPiecesBinaryRep, Board.getAllWhitePiecesBinaryRep)
      case _: BlackQueen => QueenMoves.generateMoves(piece, Board.getAllBlackPiecesBinaryRep, Board.getAllWhitePiecesBinaryRep)
    }
  }

  //  check
  // generate legal moves

}
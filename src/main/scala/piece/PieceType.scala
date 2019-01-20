package piece

object PieceType extends Enumeration {
  val pnil = 0 // empty
  val wpawn = 1
  val bpawn = 2
  val knight = 3
  val bishop = 4
  val rook = 5
  val queen = 6
  val king = 7
}

object PieceCode extends Enumeration {
  val empty: Int = PieceType.pnil // 0
  val wpawn: Int = PieceType.wpawn // 1
  val woff: Int = PieceType.bpawn // 2
  val wknight: Int = PieceType.knight // 3
  val wbishop: Int = PieceType.bishop // 4
  val wrook: Int = PieceType.rook // 5
  val wqueen: Int = PieceType.queen // 6
  val wking: Int = PieceType.king // 7

  val epc_blacky = 8
  val boff: Int = PieceType.wpawn + epc_blacky //9
  val bpawn: Int = PieceType.bpawn + epc_blacky // 10
  val bknight: Int = PieceType.knight + epc_blacky // 11
  val bbishop: Int = PieceType.bishop + epc_blacky // 12
  val brook: Int = PieceType.rook + epc_blacky // 13
  val bqueen: Int = PieceType.queen + epc_blacky // 14
  val bking: Int = PieceType.king + epc_blacky // 15
}
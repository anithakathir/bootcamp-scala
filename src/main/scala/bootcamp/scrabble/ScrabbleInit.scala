package com.indix.bootcamp.scrabble



object ScrabbleInit {


  def initPointsMap(): Map[Char, Int] =
  {
    val list = List.range('a','{').zip(List(1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10))

    val charPointsMap = list.toMap

    charPointsMap

  }

  def initScrabbleBoard(): Map[Set[Int],String]=
  {
    //val scrabbleBoard: Array[Array[Int]] = Array.ofDim(15, 15)
    val scrabbleBoard: Map[Set[Int],String] =
    Map(
    Set(14,14) -> "TW",
    Set(11,14) -> "DL",
    Set(7,14) -> "TW",
    Set(3,14) -> "DL",
    Set(0,14) -> "TW"
    )
  scrabbleBoard
  }
}
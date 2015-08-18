package com.indix.bootcamp.scrabble

import com.indix.bootcamp.scrabble.ScrabbleBoard

object Scrabble
{
  val charPointsMap = ScrabbleBoard.initPointsMap()
  val scrabbleBoard = ScrabbleBoard.initScrabbleBoard()

  def calculateScores(word:Array[Char],position :Set[Int], direction: String):Int = {
    val characterPoints = (0 to word.length-1).map { index => pointsForChar(word(index), nextPosition(Set(position.head, position.last), index, direction))}.sum
    characterPoints * (0 to word.length-1).map { index => scoreBooster(position,index,direction)}.product
  }

  def nextPosition(currentPos:Set[Int], index: Int, direction: String): Set[Int] ={
    direction match {
      case "RIGHT" => Set(currentPos.head, currentPos.last + index)
      case "DOWN" => Set(currentPos.head - index, currentPos.last)
    }
  }

  def scoreBooster(position: Set[Int], index: Int, direction: String): Int ={
    val cell = nextPosition(Set(position.head,position.last),index,direction)
    scrabbleBoard(cell.head)(cell.last).wordMultiplier
  }

  def pointsForChar(char:Char, position: Set[Int]):Int = {
    charPointsMap.getOrElse(char, 0) * scrabbleBoard(position.head)(position.last).letterMultiplier
  }
}


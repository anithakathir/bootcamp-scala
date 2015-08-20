package com.indix.bootcamp.scrabble

import com.indix.bootcamp.scrabble.ScrabbleBoard

case class Position(x: Int, y: Int)

object Scrabble
{
  val charPointsMap = ScrabbleBoard.initPointsMap()
  val scrabbleBoard = ScrabbleBoard.initScrabbleBoard()

  def calculateScores(word:Array[Char],position :Position, direction: String):Int = {
    val characterPoints = word.indices.map { index => pointsForChar(word(index), nextPosition(Position(position.x, position.y), index, direction))}.sum
    characterPoints * word.indices.map { index => scoreBooster(position,index,direction)}.product
  }

  def nextPosition(currentPos:Position, index: Int, direction: String): Position ={
    direction match {
      case "RIGHT" => Position(currentPos.x, currentPos.y + index)
      case "DOWN" => Position(currentPos.x - index, currentPos.y)
    }
  }

  def scoreBooster(position: Position, index: Int, direction: String): Int ={
    val cell = nextPosition(Position(position.x,position.y),index,direction)
    scrabbleBoard(cell.x)(cell.y).wordMultiplier
  }

  def pointsForChar(char:Char, position: Position):Int = {
    charPointsMap.getOrElse(char, 0) * scrabbleBoard(position.x)(position.y).letterMultiplier
  }
}


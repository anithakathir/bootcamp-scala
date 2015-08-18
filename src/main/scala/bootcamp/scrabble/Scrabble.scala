package com.indix.bootcamp.scrabble

import com.indix.bootcamp.scrabble.ScrabbleInit


object Scrabble
{
  val init = new ScrabbleInit()
  val charPointsMap = init.initPointsMap()
  val scrabbleBoard:Array[Array[Some[Cell]]] = init.initScrabbleBoard()

  val (right, down) = ('R','D')
  var doubleMultiplierFlag,tripleMultiplierFlag,counter = 0;


  def calculateScores(word:Array[Char],x: Int,y: Int, direction: Char):Int = {

    var points: Int = 0

    points = word.foldLeft(0) { (acc, c) =>
      direction match {
        case right => acc + boostPoints(c, x, y + counter)
        case down => acc + boostPoints(c, x - counter, y)
      }
    }
    booster(points).toInt
  }

  def boostPoints(char:Char, x:Int, y:Int):Int = {
        val charpoints = charPointsMap.getOrElse(char, 0) * scrabbleBoard(x)(y).get.letterMultiplier
        if (scrabbleBoard(x)(y).get.wordMultiplier == 3) tripleMultiplierFlag += 1
        else if (scrabbleBoard(x)(y).get.wordMultiplier == 2) doubleMultiplierFlag += 1
        counter += 1
    charpoints
  }

  def booster(points : Int): Double = {
    var p:Double = points.toDouble
    if(tripleMultiplierFlag!=0)
      p = p * scala.math.pow(3,tripleMultiplierFlag)
    if(doubleMultiplierFlag!=0)
      p = p * scala.math.pow(2,doubleMultiplierFlag)
    p
  }
}


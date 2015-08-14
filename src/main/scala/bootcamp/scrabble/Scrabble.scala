package com.indix.bootcamp.scrabble

import sun.security.x509.CRLDistributionPointsExtension


object Scrabble {

  val charPointsMap = ScrabbleInit.initPointsMap()
  val scrabbleBoard = ScrabbleInit.initScrabbleBoard()
  var doubleMultiplierFlag = 0;
  var tripleMultiplierFlag = 0;
  var charpoints = 0

  def calculateScores(word:Array[Char],positionX: Int,positionY: Int, direction: Char):Int = {

    var points:Int = 0
    var x = positionX
    var y = positionY

    direction match {
      case 'R' => word.map{c => points = points + boostPoints(c,x,y)
                            y += 1
                          }

      case 'D' => word.map{c => points = points + boostPoints(c,x,y)
                            x-= 1
                          }
    }
    println("Points :" + points )

    val finalPoints = booster(points)

    finalPoints.toInt
  }

  def boostPoints(char:Char, x:Int, y:Int):Int = {

    var multiplier = scrabbleBoard.get(Set(x,y))

    multiplier match {
      case Some("TL") => charpoints = charPointsMap.getOrElse(char,0) * 3
      case Some("DL") => charpoints = charPointsMap.getOrElse(char,0) * 2
      case _ | Some("TW") | Some("DW")  => {
        charpoints = charPointsMap.getOrElse(char,0)
        if(multiplier == Some("TW")) tripleMultiplierFlag += 1
        if(multiplier == Some("DW")) doubleMultiplierFlag += 1
      }
    }
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

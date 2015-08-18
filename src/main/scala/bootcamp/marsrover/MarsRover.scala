package com.indix.bootcamp.marsrover

object MarsRover {

  val left: Char = 'L'

  val rotateLeftMap: Map[Char,Char] = Map('S'->'E','E'->'N','N'->'W','W'->'S')
  val rotateRightMap: Map[Char,Char] = Map('S'->'W','W'->'N','N'->'E','E'->'S')

  def moveForward(currentPosition: Set[Int], head: Char): Set[Int] ={
    head match{
      case 'N' => Set(currentPosition.head,currentPosition.last + 1)
      case 'S' => Set(currentPosition.head,currentPosition.last - 1)
      case 'E' => Set(currentPosition.head + 1,currentPosition.last)
      case 'W' => Set(currentPosition.head - 1,currentPosition.last)
    }
  }

  def processRoverMovement(initPosition: Set[Int],initHead: Char, commandList: String): (Set[Int],Char) ={

    commandList.foldLeft(initPosition,initHead){
      (position,command) => {
        command match{
          case 'L' =>  (position._1,rotateLeftMap(position._2))
          case 'R' =>  (position._1,rotateRightMap(position._2))
          case 'M' => (moveForward(position._1,position._2),position._2)
        }
      }
    }
  }
}



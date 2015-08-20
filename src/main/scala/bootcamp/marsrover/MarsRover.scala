package com.indix.bootcamp.marsrover

case class Position(x:Int, y:Int)

object MarsRover {

  object Directions extends Enumeration
  {
    type Directions = Value
    val north = 'N'
    val east = 'E'
    val south = 'S'
    val west = 'W'
  }

  val directions = List('N','E','S','W')


  def rotateLeft(head: Char): Char={
    directions.reverse((directions.reverse.indexOf(head) + 1)% directions.length )
  }

  def rotateRight(head: Char): Char={
    directions((directions.indexOf(head) + 1)% directions.length )
  }


  def moveForward(currentPosition: Position, head: Char): Position ={
    head match{
      case Directions.north => Position(currentPosition.x,currentPosition.y + 1)
      case Directions.south => Position(currentPosition.x,currentPosition.y - 1)
      case Directions.east => Position(currentPosition.x + 1,currentPosition.y)
      case Directions.west => Position(currentPosition.x - 1,currentPosition.y)
    }
  }
  def processRoverMovement(maxPosition : Position, initPosition: Position,initHead: Char, commandList: String): (Position,Char) ={
    commandList.foldLeft(initPosition,initHead){
      (position,command) => {
        if((position._1.x > maxPosition.x) || (position._1.y > maxPosition.y))
          throw new IllegalStateException("Not allowed to go beyond the plateau")
          else {
          command match {
            case 'L' => (position._1, rotateLeft(position._2))
            case 'R' => (position._1, rotateRight(position._2))
            case 'M' => (moveForward(position._1, position._2), position._2)
          }
        }
      }
    }
  }
}



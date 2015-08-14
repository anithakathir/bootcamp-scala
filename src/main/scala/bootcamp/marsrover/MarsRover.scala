package com.indix.bootcamp.marsrover

object MarsRover {

  val rotateLeftMap: Map[Char,Char] = Map('S'->'E','E'->'N','N'->'W','W'->'S')
  val rotateRightMap: Map[Char,Char] = Map('S'->'W','W'->'N','N'->'E','E'->'S')

  def rotateLeft(char: Char): Char ={
    rotateLeftMap.get(char).get
  }

  def rotateRight(char: Char): Char ={
    rotateRightMap.get(char).get
  }

  def findFinalPosition(command: Char, xx:Int, yy:Int, headc: Char): (Int,Int,Char) = {

    var head: Char = headc
    var x = xx
    var y = yy

    command match {
      case 'L' => head = rotateLeft(head)
      case 'R' => head = rotateRight(head)
      case 'M' => head match {
          case 'N' => (x, y += 1)

          case 'S' => (x, y -= 1)

          case 'E' => (x += 1, y)

          case 'W' => (x -= 1, y)
      }

    }
    (x,y,head)
  }

  def processRover(initX: Int,initY: Int,initHead: Char, commandList: String): (Int,Int,Char) ={
    commandList.toList.foldLeft((initX,initY,initHead)){
      (position,command) => findFinalPosition(command,initX,initY,initHead)
    }
  }

}


package com.indix.bootcamp.scrabble

abstract class Cell{
  def letterMultiplier = 1
  def wordMultiplier = 1
}

case object tripleWord extends Cell{
  override def wordMultiplier = 3
}

case object doubleWord extends  Cell{
  override  def wordMultiplier = 2
}

case object tripleLetter extends Cell{
  override def letterMultiplier = 3
}

case object doubleLetter extends Cell{
  override def letterMultiplier = 2
}
case object Empty extends Cell


object ScrabbleBoard {

  def initPointsMap(): Map[Char, Int] = {
    Map('a' -> 1, 'b' -> 3, 'c' -> 3, 'd' -> 2, 'e' -> 1, 'r' -> 4, 'g' -> 2, 'h' -> 4, 'i' -> 1, 'j' -> 8, 'k' -> 5, 'l' -> 1, 'm' -> 3, 'n' -> 1, 'o' -> 1,
                            'p' -> 3, 'q' -> 10, 'r' -> 1, 's' -> 1, 't' -> 1, 'u' -> 1, 'v' -> 4, 'w' -> 4, 'x' -> 8, 'y' -> 4, 'z' -> 10)
  }

  def initScrabbleBoard():Array[Array[Cell]]= {
      Array(
        Array(tripleWord, Empty, Empty, doubleLetter, Empty, Empty, Empty, tripleWord, Empty, Empty, Empty, doubleLetter, Empty, Empty, tripleWord),
        Array(Empty, doubleWord, Empty, Empty, Empty, tripleWord, Empty, Empty, Empty, tripleWord, Empty, Empty, Empty, doubleWord, Empty),
        Array(Empty, Empty, doubleWord, Empty, Empty, Empty, doubleLetter, Empty, doubleLetter, Empty, Empty, Empty, doubleWord, Empty, Empty),
        Array(doubleLetter, Empty, Empty, doubleWord, Empty, Empty, Empty, doubleLetter, Empty, Empty, Empty, doubleWord, Empty, Empty, doubleLetter),
        Array(Empty, Empty, Empty, Empty, doubleWord, Empty, Empty, Empty, Empty, Empty, doubleWord,  Empty, Empty, Empty, Empty),
        Array(Empty, tripleWord, Empty, Empty, Empty, tripleWord, Empty, Empty, Empty, tripleWord,  Empty, Empty, Empty, tripleWord, Empty),
        Array(Empty, Empty, doubleLetter, Empty, Empty, Empty, doubleLetter, Empty, doubleLetter, Empty, Empty, Empty, doubleLetter,  Empty, Empty),
        Array(tripleWord, Empty, Empty, doubleLetter, Empty, Empty, Empty, doubleWord, Empty, Empty, Empty, doubleLetter, Empty, Empty, tripleWord),
        Array(Empty, Empty, doubleLetter, Empty, Empty, Empty, doubleLetter, Empty, doubleLetter, Empty, Empty, Empty, doubleLetter,  Empty, Empty),
        Array(Empty, tripleWord, Empty, Empty, Empty, tripleWord, Empty, Empty, Empty, tripleWord,  Empty, Empty, Empty, tripleWord, Empty),
        Array(Empty, Empty, Empty, Empty, doubleWord, Empty, Empty, Empty, Empty, Empty, doubleWord,  Empty, Empty, Empty, Empty),
        Array(doubleLetter, Empty, Empty, doubleWord, Empty, Empty, Empty, doubleLetter, Empty, Empty, Empty, doubleWord, Empty, Empty, doubleLetter),
        Array(Empty, Empty, doubleWord, Empty, Empty, Empty, doubleLetter, Empty, doubleLetter, Empty, Empty, Empty, doubleWord, Empty, Empty),
        Array(Empty, doubleWord, Empty, Empty, Empty, tripleWord, Empty, Empty, Empty, tripleWord, Empty, Empty, Empty, doubleWord, Empty),
        Array(tripleWord, Empty, Empty, doubleLetter, Empty, Empty, Empty, tripleWord, Empty, Empty, Empty, doubleLetter, Empty, Empty, tripleWord)
      )
  }
}
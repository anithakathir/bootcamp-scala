package com.indix.bootcamp.scrabble

abstract class Cell{
  def letterMultiplier = 1
  def wordMultiplier = 1
}

case object TripleWord extends Cell{
  override def wordMultiplier = 3
}

case object DoubleWord extends  Cell{
  override  def wordMultiplier = 2
}

case object TripleLetter extends Cell{
  override def letterMultiplier = 3
}

case object DoubleLetter extends Cell{
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
        Array(TripleWord, Empty, Empty, DoubleLetter, Empty, Empty, Empty, TripleWord, Empty, Empty, Empty, DoubleLetter, Empty, Empty, TripleWord),
        Array(Empty, DoubleWord, Empty, Empty, Empty, TripleWord, Empty, Empty, Empty, TripleWord, Empty, Empty, Empty, DoubleWord, Empty),
        Array(Empty, Empty, DoubleWord, Empty, Empty, Empty, DoubleLetter, Empty, DoubleLetter, Empty, Empty, Empty, DoubleWord, Empty, Empty),
        Array(DoubleLetter, Empty, Empty, DoubleWord, Empty, Empty, Empty, DoubleLetter, Empty, Empty, Empty, DoubleWord, Empty, Empty, DoubleLetter),
        Array(Empty, Empty, Empty, Empty, DoubleWord, Empty, Empty, Empty, Empty, Empty, DoubleWord,  Empty, Empty, Empty, Empty),
        Array(Empty, TripleWord, Empty, Empty, Empty, TripleWord, Empty, Empty, Empty, TripleWord,  Empty, Empty, Empty, TripleWord, Empty),
        Array(Empty, Empty, DoubleLetter, Empty, Empty, Empty, DoubleLetter, Empty, DoubleLetter, Empty, Empty, Empty, DoubleLetter,  Empty, Empty),
        Array(TripleWord, Empty, Empty, DoubleLetter, Empty, Empty, Empty, DoubleWord, Empty, Empty, Empty, DoubleLetter, Empty, Empty, TripleWord),
        Array(Empty, Empty, DoubleLetter, Empty, Empty, Empty, DoubleLetter, Empty, DoubleLetter, Empty, Empty, Empty, DoubleLetter,  Empty, Empty),
        Array(Empty, TripleWord, Empty, Empty, Empty, TripleWord, Empty, Empty, Empty, TripleWord,  Empty, Empty, Empty, TripleWord, Empty),
        Array(Empty, Empty, Empty, Empty, DoubleWord, Empty, Empty, Empty, Empty, Empty, DoubleWord,  Empty, Empty, Empty, Empty),
        Array(DoubleLetter, Empty, Empty, DoubleWord, Empty, Empty, Empty, DoubleLetter, Empty, Empty, Empty, DoubleWord, Empty, Empty, DoubleLetter),
        Array(Empty, Empty, DoubleWord, Empty, Empty, Empty, DoubleLetter, Empty, DoubleLetter, Empty, Empty, Empty, DoubleWord, Empty, Empty),
        Array(Empty, DoubleWord, Empty, Empty, Empty, TripleWord, Empty, Empty, Empty, TripleWord, Empty, Empty, Empty, DoubleWord, Empty),
        Array(TripleWord, Empty, Empty, DoubleLetter, Empty, Empty, Empty, TripleWord, Empty, Empty, Empty, DoubleLetter, Empty, Empty, TripleWord)
      )
  }
}
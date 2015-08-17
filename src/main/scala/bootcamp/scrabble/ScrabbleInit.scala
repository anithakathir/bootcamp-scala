package com.indix.bootcamp.scrabble

class Cell{
  def letterMultiplier = 1
  def wordMultiplier = 1
}

class TripleWord extends Cell{
  override def wordMultiplier = 3
}

class DoubleWord extends  Cell{
  override  def wordMultiplier = 2
}

class TripleLetter extends Cell{
  override def letterMultiplier = 3
}

class DoubleLetter extends Cell{
  override def letterMultiplier = 2
}

class ScrabbleInit {

  val tripleWord = Some(new TripleWord())
  val doubleWord = Some(new DoubleWord())
  val tripleLetter = Some(new TripleLetter())
  val doubleLetter = Some(new DoubleLetter())
  val empty = Some(new Cell())
  

  def initPointsMap(): Map[Char, Int] =
  {
    Map('a' -> 1, 'b' -> 3, 'c' -> 3, 'd' -> 2, 'e' -> 1, 'r' -> 4, 'g' -> 2, 'h' -> 4, 'i' -> 1, 'j' -> 8, 'k' -> 5, 'l' -> 1, 'm' -> 3, 'n' -> 1, 'o' -> 1,
                            'p' -> 3, 'q' -> 10, 'r' -> 1, 's' -> 1, 't' -> 1, 'u' -> 1, 'v' -> 4, 'w' -> 4, 'x' -> 8, 'y' -> 4, 'z' -> 10)
  }

  def initScrabbleBoard():Array[Array[Some[Cell]]]= {

      Array(
        Array(tripleWord, empty, empty, doubleLetter, empty, empty, empty, tripleWord, empty, empty, empty, doubleLetter, empty, empty, tripleWord),
        Array(empty, doubleWord, empty, empty, empty, tripleWord, empty, empty, empty, tripleWord, empty, empty, empty, doubleWord, empty),
        Array(empty, empty, doubleWord, empty, empty, empty, doubleLetter, empty, doubleLetter, empty, empty, empty, doubleWord, empty, empty),
        Array(doubleLetter, empty, empty, doubleWord, empty, empty, empty, doubleLetter, empty, empty, empty, doubleWord, empty, empty, doubleLetter),
        Array(empty, empty, empty, empty, doubleWord, empty, empty, empty, empty, empty, doubleWord,  empty, empty, empty, empty),
        Array(empty, tripleWord, empty, empty, empty, tripleWord, empty, empty, empty, tripleWord,  empty, empty, empty, tripleWord, empty),
        Array(empty, empty, doubleLetter, empty, empty, empty, doubleLetter, empty, doubleLetter, empty, empty, empty, doubleLetter,  empty, empty),
        Array(tripleWord, empty, empty, doubleLetter, empty, empty, empty, doubleWord, empty, empty, empty, doubleLetter, empty, empty, tripleWord),
        Array(empty, empty, doubleLetter, empty, empty, empty, doubleLetter, empty, doubleLetter, empty, empty, empty, doubleLetter,  empty, empty),
        Array(empty, tripleWord, empty, empty, empty, tripleWord, empty, empty, empty, tripleWord,  empty, empty, empty, tripleWord, empty),
        Array(empty, empty, empty, empty, doubleWord, empty, empty, empty, empty, empty, doubleWord,  empty, empty, empty, empty),
        Array(doubleLetter, empty, empty, doubleWord, empty, empty, empty, doubleLetter, empty, empty, empty, doubleWord, empty, empty, doubleLetter),
        Array(empty, empty, doubleWord, empty, empty, empty, doubleLetter, empty, doubleLetter, empty, empty, empty, doubleWord, empty, empty),
        Array(empty, doubleWord, empty, empty, empty, tripleWord, empty, empty, empty, tripleWord, empty, empty, empty, doubleWord, empty),
        Array(tripleWord, empty, empty, doubleLetter, empty, empty, empty, tripleWord, empty, empty, empty, doubleLetter, empty, empty, tripleWord)
      )
  }
}
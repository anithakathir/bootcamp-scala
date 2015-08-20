package com.indix.bootcamp.scrabble

import org.scalatest.{ShouldMatchers, FlatSpec}

class ScrabbleTest extends FlatSpec with ShouldMatchers{

  "A word" should "return boosted points" in {
    Scrabble.calculateScores("indix".toLowerCase.toCharArray,Position(0,0),"RIGHT") shouldEqual 42
    Scrabble.calculateScores("unconsciousness".toLowerCase.toCharArray,Position(0,0),"RIGHT") shouldEqual 567
    Scrabble.calculateScores("cryptozoologies".toLowerCase.toCharArray,Position(14,14),"DOWN") shouldEqual 999
  }

}

package com.indix.bootcamp.scrabble

import org.scalatest.{ShouldMatchers, FlatSpec}

class ScrabbleTest extends FlatSpec with ShouldMatchers{

  "A word" should "return boosted points" in {
    val inputWord = "cryptozoologies".toLowerCase.toCharArray
    Scrabble.calculateScores(inputWord,14,14,'D') shouldEqual 999
  }

}

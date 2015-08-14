package com.indix.bootcamp.marsrover

import org.scalatest.{ShouldMatchers, FlatSpec}

class MarsRoverTest extends FlatSpec with ShouldMatchers{

  "Mars Rover" should "move in the specified direction" in {
    MarsRover.processRover(1,2,'N',"LMLMLMLMM") shouldBe (1,3,'N')
  }

}

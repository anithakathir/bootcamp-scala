package com.indix.bootcamp.marsrover

import org.scalatest.{ShouldMatchers, FlatSpec}

class MarsRoverTest extends FlatSpec with ShouldMatchers{

  "Mars Rover" should "move in the specified direction" in {
    MarsRover.processRoverMovement(Set(1,2),'N',"LMLMLMLMM") shouldBe (Set(1,3),'N')
    MarsRover.processRoverMovement(Set(3,3),'E',"MMRMMRMRRM") shouldBe (Set(5,1),'E')
  }

}

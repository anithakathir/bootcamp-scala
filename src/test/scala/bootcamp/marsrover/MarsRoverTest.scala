package com.indix.bootcamp.marsrover

import org.scalatest.{ShouldMatchers, FlatSpec}

class MarsRoverTest extends FlatSpec with ShouldMatchers{


  "Mars Rover" should "move in the specified direction" in {
    MarsRover.processRoverMovement(Position(5,5), Position(1,2),'N',"LMLMLMLMM") shouldBe (Position(1,3),'N')
    MarsRover.processRoverMovement(Position(5,5), Position(3,3),'E',"MMRMMRMRRM") shouldBe (Position(5,1),'E')
  }

  "rotateLeft" should "return the direction of the head to it's left" in {
    MarsRover.rotateLeft('N') shouldEqual 'W'
    MarsRover.rotateLeft('W') shouldEqual 'S'
    MarsRover.rotateLeft('S') shouldEqual 'E'
    MarsRover.rotateLeft('E') shouldEqual 'N'
  }

  "rotateRight" should "return the direction of the head to it's right" in {
    MarsRover.rotateRight('N') shouldEqual 'E'
    MarsRover.rotateRight('E') shouldEqual 'S'
    MarsRover.rotateRight('S') shouldEqual 'W'
    MarsRover.rotateRight('W') shouldEqual 'N'
  }

  the [IllegalStateException] thrownBy{
    MarsRover.processRoverMovement(Position(5,5), Position(6,6),'N',"LMLMLMLMM")
  } should have message "Not allowed to go beyond the plateau"

}

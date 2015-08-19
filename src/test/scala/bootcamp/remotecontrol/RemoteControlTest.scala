package com.indix.bootcamp.remotecontrol

import org.scalatest.{ShouldMatchers, FlatSpec}
import bootcamp.remotecontrol._

class RemoteControlTest extends FlatSpec with ShouldMatchers{

  def fixture ={
    new {
      val initSkyCast = new SkyCast(1,100,45,44,List(4,78,79,80,3),2)
    }
  }

  "When a list of inputs is given, findMinClicks" should "return minimum number of clicks possible" in {

    RemoteControl.findMinClicks(1, 200, List(), List(1, 100, 1, 101)) shouldEqual 7
    RemoteControl.findMinClicks(1, 100, List(4,78,79,80,3), List(10, 13, 13, 100,99,98,77,81)) shouldEqual 12
    RemoteControl.findMinClicks(103, 108, List(104), List(105, 106, 107, 103, 105)) shouldEqual 8
  }

  "navigateUp" should "return list of channels between current and target channel" in {

    val f = fixture

    f.initSkyCast.navigateUp(45,50) shouldEqual List(46,47,48,49,50)
    f.initSkyCast.navigateUp(99,2) shouldEqual List(100,1,2)
  }

  "navigateDown" should "return list of channels between current and target channel" in {

    val f = fixture

    f.initSkyCast.navigateDown(50,45) shouldEqual List(49,48,47,46,45)
    f.initSkyCast.navigateDown(2,99) shouldEqual List(1,100,99)
  }

  "directClicks" should "return current channel and number of button clicks" in {

    val f = fixture

    f.initSkyCast.directClicks(50, 100) shouldEqual (50,3)
  }

  "estimateMinClicks" should "return minimum number of clicks to reach the target channel" in {

    val f = fixture

    f.initSkyCast.estimateMinClicks(44).minClicks shouldEqual 2
  }
}

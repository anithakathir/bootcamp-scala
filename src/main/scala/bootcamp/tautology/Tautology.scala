package com.indix.bootcamp.tautology

import scala.collection.mutable

object Tautology
{
  def verifyTautology(expression: String): Int =
  {
    val tokens: Array[Char] = expression.toCharArray
    var flag: Int = 0

    var valueStack = new mutable.Stack[Int]
    var operatorstack = new mutable.Stack[Char]




    valueStack.pop()
  }

  def evaluate (operator: Char, operand2: Int, operand1: Int) {
    operator match {
      case '&' => operand1 & operand2
      case '|' => operand1 | operand2
    }
  }

}

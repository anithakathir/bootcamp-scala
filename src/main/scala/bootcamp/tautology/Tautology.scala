package com.indix.bootcamp.tautology

object Tautology {

  def isOperand(element: Char): Boolean ={
    if(List.range('a','{').contains(element)) true
    else false
  }

  def evaluateOperation(operand1: Int, operand2: Int,operator: Char): Int ={
    if(operator=='|') operand1 | operand2
    else operand1 & operand2
  }
  
  def infixToPostfix(infixExpression: String): String ={
    val (tokens,postfixExpression) = infixExpression.foldLeft((List[Char](),"")) {
      case ((acc,postFixToken),token) =>
        if(isOperand(token))
          if(acc.head=='!')
            (acc.tail, postFixToken + token + "!")
          else
            (acc, postFixToken + token)
        else if(token==')')
          (acc.dropWhile(recentToken => recentToken!='(').tail, postFixToken + acc.takeWhile(recentToken => recentToken!='(').mkString)
        else
          (token :: acc,postFixToken)
    }
    postfixExpression + tokens.mkString
  }
  
  def evaluate(variables: String, values: String,postfixExpression: String): Int ={

    val valuesMap: Map[Char,Char] = variables.toList.zip(values.toList).toMap
    postfixExpression.foldLeft(List(1)){case (acc,token) =>
      if(isOperand(token))
        valuesMap.getOrElse(token,'0').toInt::acc
      else if(token == '!') {
        acc.head match{
          case '1' => 0 :: acc.tail
          case '0' => 1 :: acc.tail
        }
      }
      else
        evaluateOperation(acc.head,acc.tail.head,token)::acc.drop(2)
    }.head
  }

}
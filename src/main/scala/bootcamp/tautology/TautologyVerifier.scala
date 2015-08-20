package bootcamp.tautology

import com.indix.bootcamp.tautology.Tautology

object TautologyVerifier {

  def verifyTautology(infixExpression: String): Int =
  {
    val infix = infixExpression.replaceAll("\\s+", "")
    val filter = (infix.indices.map(index => if(List.range('a','{').contains(infix(index))) infix(index) else null).toSet - null).toList.mkString
    val binaryNumbers: List[String] = (0 to scala.math.pow(2,filter.length).toInt-1).map(index => index.toBinaryString).toList
    val alteredBinaryNumbers = binaryNumbers.map(eachNum => if(eachNum.length != binaryNumbers.tail.length-1) 0+eachNum else eachNum)

    if(alteredBinaryNumbers.map(varWithVal => Tautology.evaluate(filter, varWithVal,Tautology.infixToPostfix(infix))).contains(0)) 0
    else 1
  }
}

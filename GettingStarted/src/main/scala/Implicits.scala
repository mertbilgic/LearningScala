case class Currency(code: String, amount: Double, toUSD: Double)

object Implicits extends App{

  implicit  def stringToCurrency(money: String): Currency = {
    val Array(code: String, value: String) = money.split("\\s")
    val amountAsDouble = value.toDouble
    code match {
      case "USD" => Currency("USD", amountAsDouble, amountAsDouble)
      case "NZD" => Currency("USD", amountAsDouble, (amountAsDouble * (1/1.5)))
      case "CAD" => Currency("USD", amountAsDouble, (amountAsDouble * (1/1.5)))
    }
  }

  println(stringToCurrency("USD 100"))
  println(stringToCurrency("NZD 100"))

  val cad: Currency = "CAD 100"
  println(cad)

}

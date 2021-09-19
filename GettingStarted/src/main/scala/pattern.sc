var amount = 100

//Literal Pattern
amount match {
  case 50 => println("$50")
  case 100 => println("$100")
  case _ => println("Not ad $50 or $100 bill")
}

// Variable Pattern
val result: String = amount match {
  case a if a >= 50 => s"bill is >= 50, it's $a "
  case a if a == 100 => s"bill is $a"
  case a => s"The amount is $a"
}

// Matching Type
abstract class Currency
case class USD() extends Currency
case class CAD() extends Currency
case class NZD() extends Currency

val currency: Currency = CAD()

currency match {
  case u: USD => println(s"USD $amount")
  case c: CAD => println("CAD " + amount * (1/1.30))
  case n: NZD => println("NZD " + amount * (1/1.50))
}

val anArray = Array(100, 200, 300)

anArray match {
  case Array(_, _, third) => println("third=" + third)
}

val aTuple = ("NZD", 100)

aTuple match {
  case (currency, amount) if currency == "USD" => println("USD " + amount)
  case (currency, amount) if currency == "CAD" => println("CAD " + amount)
  case (currency, amount) if currency == "NZD" => println("NZD " + amount)

}
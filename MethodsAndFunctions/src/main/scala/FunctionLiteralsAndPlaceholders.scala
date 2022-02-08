object FunctionLiteralsAndPlaceholders extends App{

  //Literals
  var multiplyBy = (x: Int) => x * 100

  println(multiplyBy(3))

  multiplyBy = (x: Int) => x * 1000

  println(multiplyBy(3))

  //Placeholders
  val googStockPrices = List(1367.36, 1360.66, 1394.20, 1393.33,
    1393.33, 1404.31, 1419.82, 1429.73)

  def checkPriceGreaterThan1400(price: Double): Boolean = price > 1400

  googStockPrices.foreach((price: Double) => println(price))

  val googStockPricesGreaterThan1400 =
    googStockPrices.filter((price: Double) => price>1400)

  val googStockPricesGreaterThan14002 =
    googStockPrices.filter(_ > 1400)

  val googStockPricesGreaterThan14003 =
    googStockPrices.filter(checkPriceGreaterThan1400 _)

  println(googStockPricesGreaterThan1400)
  println(googStockPricesGreaterThan14002)
  println(googStockPricesGreaterThan14003)

  val stockTickersInLowercase = List("goog", "ps", "tsla", "aapl", "msft")
  val stockTickers = stockTickersInLowercase.map(_.toUpperCase)

  println(stockTickers)

  def checkPriceInRange(price: Double, lower: Double, upper:Double): Boolean =
    price >= lower && price <= upper

  //val googStockPricesInRangeFunction = checkPriceInRange _
  val googStockPricesInRangeFunction = checkPriceInRange(_: Double, _:Double, 1410)

  val googStockPricesInRange =
    googStockPrices.filter((price) => googStockPricesInRangeFunction(price, 1390))

  println(googStockPrices)
}

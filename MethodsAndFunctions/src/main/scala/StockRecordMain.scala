import scala.io.Source

object StockRecordMain extends App{

  val source = io.Source.fromFile("src/main/resources/GOOG.csv")

  val readFinanceData = (source: Source) => {
    for{
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5).toFloat,
      cols(6).toDouble)
  }

  var data = readFinanceData(source)

  val getTotalNumberOfRows = () => data.size

  val getAvgCloseValue = () => data.map(_.close).sum / data.size

  val getMinCloseValue = () => data.map(_.close).min

  val getMaxClouseValue = () => data.map(_.close).max

  val getCloseValueOnDate = (givenDate: String) => {
    val filteredClose = data.filter(_.date == givenDate)
      filteredClose.map(_.close).head
  }

  println(s"Dataset size: ${getTotalNumberOfRows()}")
  println(s"Average close: ${getAvgCloseValue()}")
  println(s"Min close: ${getMinCloseValue()}")
  println(s"Max close: ${getMaxClouseValue()}")
  val date = "2020-01-03"
  println(s"Close value on $date: ${getCloseValueOnDate(date)}")

  val priceDelta = (_: Double) - (_: Double)

  val getDailyDelta = (openPrice: Double, closePrice: Double,
                        delta:(Double, Double) => Double) =>delta(openPrice, closePrice)

  val record = data.filter(_.date == "2020-01-03")

  println(getDailyDelta(record(0).open, record(0).close, priceDelta))
}

import java.util.UUID

class Customer(first: String, last: String, email: String) {
  private val _id: UUID = UUID.randomUUID()
  private val _first = first
  private val _last = last
  private val _email = email

  def getId: UUID = _id

  def getFirst: String = _first

  def getLast: String = _last

  def getEmail: String = _email

}

trait Address {
  protected var _zip: Int
  protected var _street: String
  protected var _state: String

  def setZip(zip: Int): Unit
  def setStreet(street: String): Unit
  def setState(state: String): Unit
  def printAddress(): Unit = println(s"${_street}, ${_state}, ${_zip}")
}
trait Secret{
  def getOTP: String = UUID.randomUUID().toString
}

class CustomerWithAddress(first: String, last: String, email: String) extends Customer(first, last, email)
  with  Address with  Secret {
  override protected var _zip: Int = -1
  override protected var _street: String = ""
  override protected var _state: String = ""

  override def setZip(zip: Int): Unit = _zip = zip

  override def setStreet(street: String): Unit = _street = street

  override def setState(state: String): Unit = _state = state
}

object EmailRunner extends App {
  val c1: Customer = new Customer("Tony", "Stark", "tony@stark.com")
  println(c1.getId, c1.getFirst, c1.getLast, c1.getEmail)

  val c2 = new CustomerWithAddress("Tony2", "Stark2", "tony2@stark.com")
  c2.setZip(95050)
  c2.setStreet("45 Fremont St")
  c2.setState("California")
  println(c2.getFirst, c2.getLast, c2.getEmail)
  c2.printAddress()
  println(c2.getOTP)


}
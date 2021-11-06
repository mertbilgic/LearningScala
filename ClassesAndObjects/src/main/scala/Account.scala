import java.time.LocalDateTime
import java.util.UUID

abstract class Account(id: UUID, name: String, dateOpened: LocalDateTime) {

  private val _id: UUID = id
  private var _name: String = name
  private val _dateOpened: LocalDateTime = dateOpened
  val _accountType: String

  def this(name: String) {
    this(UUID.randomUUID(), name, LocalDateTime.now)
  }

  def getId: UUID = _id

  def getName: String = _name

  def getDateOpened: LocalDateTime = _dateOpened

  def updateName(newName: String): Unit = _name = newName

  def getAccountType: String = _accountType

  override def toString: String = s"Account id=${_id},name=${_name},dateOpened=${_dateOpened}"
}

class CreditAccount(name: String) extends Account(name: String) {
  override val _accountType: String = "Credit"
  override def toString: String = s"Credit Account id=${getId},name=${getName},dateOpened=${getDateOpened},accountType=${getAccountType}"
}

class DepositsAccount(name: String) extends Account(name: String) {
  override val _accountType: String = "Deposit"
  override def toString: String = s"Deposit Account id=${getId},name=${getName},dateOpened=${getDateOpened},accountType=${getAccountType}"
}

object AccountRunner extends App {

  val ca1: Account = new CreditAccount("Travel Mastercard")
  println(ca1)

  val da1: Account = new DepositsAccount("Super Savings")
  println(da1)


}
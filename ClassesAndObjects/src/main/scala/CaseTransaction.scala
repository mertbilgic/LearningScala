import java.time.LocalDateTime

sealed trait Kind

case object Debit extends Kind

case object Credit extends Kind

case object Refund extends Kind

case class TransactionCase(name: String, amount: Double, kind: Kind, when: LocalDateTime)

object CaseTransactionRunner extends App {
  private val when = LocalDateTime.now

  val t1 = TransactionCase("T1", 12.22, Debit, when)
  println(t1.toString)

  val t2 = TransactionCase("T1", 12.22, Credit, when)

  println(t1 == t2)
  println(t1.hashCode())

  val t3 = t1.copy("T3", amount = 100.34, kind = Refund)

  println(t3)

  val amount = t3 match {
    case TransactionCase(_, amount, kind, _) if kind == Debit && amount > 20 => amount - 20
    case t: TransactionCase => t.amount
  }
  println(amount)
  //scalac src/main/scala/Transaction.scala

  def getMessage(kind: Kind): String = kind match {
    case Debit => "Debit Transaction"
    case Credit => "Credit Transaction"
    case Refund => "Refund Transaction"
  }

  println(getMessage(t3.kind))

}

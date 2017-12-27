package example

sealed abstract class Money {
  def times(multiplier: Int): Money
}

case class Dollar(private val amount: Int) extends Money {

  override def times(multiplier: Int): Money =
    Dollar(this.amount * multiplier)

}

case class Franc(private val amount: Int) extends Money {

  override def times(multiplier: Int): Money =
    Franc(this.amount * multiplier)

}

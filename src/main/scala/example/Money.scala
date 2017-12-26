package example

sealed trait Money {
  def times(multiplier: Int): Money
}

case class Dollar(private val amount: Int) extends Money {

  override def times(multiplier: Int): Dollar = Dollar(this.amount * multiplier)

}

case class Franc(private val amount: Int) extends Money {

  override def times(multiplier: Int): Franc = Franc(this.amount * multiplier)

}
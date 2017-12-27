package example

sealed abstract class Money {

  val currencyUnit: MyCurrencyUnit

  def times(multiplier: Int): Money
}

case class Dollar(private val amount: Int) extends Money {

  val currencyUnit: MyCurrencyUnit = MyCurrencyUnit.USD

  override def times(multiplier: Int): Money =
    Dollar(this.amount * multiplier)

}

case class Franc(private val amount: Int) extends Money {

  val currencyUnit: MyCurrencyUnit = MyCurrencyUnit.CHF

  override def times(multiplier: Int): Money =
    Franc(this.amount * multiplier)

}

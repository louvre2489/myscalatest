package example

sealed abstract class Money {

  implicit val currencyUnit: MyCurrencyUnit

  def moneyAmount: Int

  def times(multiplier: Int): Money =
    MyCurrency(this.moneyAmount * multiplier)

}

case class Dollar(private val dollarAmount: Int) extends Money {

  override def moneyAmount: Int = dollarAmount

  implicit val currencyUnit: MyCurrencyUnit = MyCurrencyUnit.USD

}

case class Franc(private val francAmount: Int) extends Money {

  override def moneyAmount: Int = francAmount

  implicit val currencyUnit: MyCurrencyUnit = MyCurrencyUnit.CHF

}

package example

case class Franc(val amount: Int) {

  def times(multiplier: Int): Franc = Franc(this.amount * multiplier)
}

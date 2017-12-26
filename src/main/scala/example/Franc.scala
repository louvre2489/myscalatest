package example

case class Franc(private var amount: Int) {

  def times(multiplier: Int): Franc = Franc(this.amount * multiplier)

}
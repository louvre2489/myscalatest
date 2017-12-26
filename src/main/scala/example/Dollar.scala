package example

case class Dollar(private var amount: Int) {

  def times(multiplier: Int): Dollar = Dollar(this.amount * multiplier)

}
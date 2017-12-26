package example

case class Dollar(var amount: Int) {

  def times(multiplier: Int): Dollar = Dollar(this.amount * multiplier)

}

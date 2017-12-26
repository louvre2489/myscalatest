package example

case class Dollar(var amount: Int) {

  def times(multiplier: Int): Unit = this.amount = this.amount * multiplier

}

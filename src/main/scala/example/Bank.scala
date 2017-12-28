package example

trait Expression {

  def reduce(to: MyCurrency): Money

}

case class Sum(augend: Money, addend: Money) extends Expression {

  override def reduce(to: MyCurrency): Money = {

    val amount: Int = augend.moneyAmount + addend.moneyAmount
    MyCurrency(to)(amount)
  }

}

class Bank {

  def reduce(source: Expression, to: MyCurrency): Money = source.reduce(to)
}
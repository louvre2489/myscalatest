package example

trait Expression {
}

class Bank {

  def reduce(source: Expression, to: MyCurrency): Money = MyCurrency(MyCurrency.USD)(10)

}
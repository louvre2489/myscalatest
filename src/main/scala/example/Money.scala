package example

sealed abstract class Money extends Expression {

  /**
    * 通貨単位
    */
  val currencyUnit: MyCurrency

  /**
    * 継承先のクラスの通貨に応じた金額を設定する
    *
    * @return 金額
    */
  def moneyAmount: Int

  /**
    * 金額をmultiplierで指定された数値倍して返す。
    * オブジェクトは新たに生成し、既存オブジェクトに変更は加えない。
    *
    * @param multiplier 金額を掛け算するための数値
    * @return 元の金額を指定倍した新たなオブジェクト
    */
  def times(multiplier: Int): Money =
    MyCurrency(currencyUnit)(this.moneyAmount * multiplier)

  def plus(addend: Money): Expression = Sum(this, addend)

  override def reduce(to: MyCurrency): Money = this

}

/**
  * ドルクラス
  *
  * @param dollarAmount ドル単位での金額
  */
case class Dollar(private val dollarAmount: Int) extends Money {

  override def moneyAmount: Int = dollarAmount

  val currencyUnit: MyCurrency = MyCurrency.USD

}

/**
  * フランクラス
  *
  * @param francAmount フラン単位での金額
  */
case class Franc(private val francAmount: Int) extends Money {

  override def moneyAmount: Int = francAmount

  val currencyUnit: MyCurrency = MyCurrency.CHF

}

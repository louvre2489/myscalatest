package example

/**
  * 通貨クラス
  */
sealed abstract class Money extends Expression {

  //通貨単位
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
  def times(multiplier: Int): Expression =
    MyCurrency(currencyUnit)(this.moneyAmount * multiplier)

  /**
    * 自オブジェクトと引数オブジェクトの金額を足し算する。
    *
    * @param addend 足す数
    * @return 足し算結果
    */
  override def plus(addend: Expression): Expression =
    Sum(this, addend)

  /**
    * 簡約を実施してMoneyオブジェクトを作成する。
    * 簡約の際に、自オブジェクトと引数オブジェクトの通貨単位の違いを考慮し、
    * 通貨が異なる場合はレート換算を行う。
    *
    * @param bank 換算情報を持ったBankのオブジェクト
    * @param to   toで指定された通貨へとレート換算し、Moneyオブジェクトを生成する
    * @return toで指定された通貨のMoneyオブジェクト
    */
  override def reduce(bank: Bank, to: MyCurrency): Money = {

    val rate: Int = bank.rate(this.currencyUnit, to)
    MyCurrency(to)(this.moneyAmount / rate)

  }

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

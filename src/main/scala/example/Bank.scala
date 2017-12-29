package example

trait Expression {

  def reduce(bank: Bank, to: MyCurrency): Money

}

case class Sum(augend: Money, addend: Money) extends Expression {

  override def reduce(bank: Bank, to: MyCurrency): Money = {

    val amount: Int = augend.moneyAmount + addend.moneyAmount
    MyCurrency(to)(amount)
  }

}

/**
  * 換算に関する情報を扱うクラス
  */
class Bank {

  import scala.collection.mutable.{Map => MutableMap}
  import scala.collection.mutable.{HashMap => MutableHashMap}

  // 為替レート
  private val rates: MutableMap[(MyCurrency, MyCurrency), Int] =
    MutableHashMap[(MyCurrency, MyCurrency), Int]()

  /**
    * Expressionの簡約を実行する。
    *
    * @param source 簡約の対象
    * @param to 対象通貨
    * @return 通貨オブジェクト
    */
  def reduce(source: Expression, to: MyCurrency): Money = source.reduce(this, to)

  /**
    * レートを設定する。
    *
    * @param from 変換元通貨
    * @param to 変換先通貨
    * @param rate レート
    */
  def addRate(from: MyCurrency, to: MyCurrency, rate: Int): Unit = {
    rates.put((from, to), rate)
  }

  /**
    * レートを取得する。
    * 変換前と変換先の通貨が同一の場合は、1固定
    *
    * @param from 変換前の通貨
    * @param to 変換先の通貨
    * @return レート
    */
  def rate(from: MyCurrency, to: MyCurrency): Int =
    if (from == to) 1 else rates((from, to))

}
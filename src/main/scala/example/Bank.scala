package example

/**
  * 式をを表すクラスに実装するtrait
  */
trait Expression {

  /**
    * 掛け算
    *
    * @param multiplier 掛ける数
    * @return 乗算式
    */
  def times(multiplier: Int): Expression

  /**
    * 足し算
    *
    * @param addend 足す数
    * @return 和算式
    */
  def plus(addend: Expression): Expression

  /**
    * 簡約
    *
    * @param bank 換算情報
    * @param to 変換先の通貨
    * @return 通貨オブジェクト
    */
  def reduce(bank: Bank, to: MyCurrency): Money

}

/**
  * 和算式
  *
  * @param augend 足される数
  * @param addend 足す数
  */
case class Sum(augend: Expression, addend: Expression) extends Expression {

  override def times(multiplier: Int): Expression =
    Sum(augend times multiplier, addend times multiplier)

  /**
    * 足し算
    *
    * @param addend 足す数
    * @return 和算式
    */
  override def plus(addend: Expression): Expression =
    Sum(this, addend)

  /**
    * 簡約を実施する。
    * 簡約の際、変換先の通貨にレート換算してから実施する。
    *
    * @param bank 換算情報
    * @param to 変換先の通貨
    * @return 通貨オブジェクト
    */
  override def reduce(bank: Bank, to: MyCurrency): Money = {

    val amount: Int = augend.reduce(bank, to).moneyAmount + addend.reduce(bank, to).moneyAmount
    MyCurrency(to)(amount)
  }

}

/**
  * 換算に関する情報を扱うクラス
  */
class Bank {

  import collection.{mutable => m}

  // 為替レート
  private val rates: m.Map[(MyCurrency, MyCurrency), Int] =
    m.HashMap[(MyCurrency, MyCurrency), Int]()

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
package example

sealed trait MyCurrency

/**
  * 通貨を生成する
  */
object MyCurrency {

  /** 通貨単位の定義 **/
  // Dollar
  case object USD extends MyCurrency

  // Franc
  case object CHF extends MyCurrency

  /**
    * 通貨単位を元に通貨を生成する
    *
    * @param currencyUnit 通貨単位
    * @param amount       金額
    * @return 金額オブジェクト
    */
  def apply(currencyUnit: MyCurrency)(amount: Int): Money =
    currencyUnit match {
      case MyCurrency.USD => Dollar(amount)
      case MyCurrency.CHF => Franc(amount)
    }
}
package example

sealed trait MyCurrency

/**
  * 通貨を生成する
  */
object MyCurrency {

  /**
    * 通貨単位を元に通貨を生成する
    */
  def apply(amount: Int)(implicit currencyUnit: MyCurrencyUnit): Money =
    currencyUnit match {
      case MyCurrencyUnit.USD => Dollar(amount)
      case MyCurrencyUnit.CHF => Franc(amount)
    }
}
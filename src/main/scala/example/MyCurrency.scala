package example

/**
  * 通貨生成用のtrait
  * MyCurrencyを実装したcase objectを通貨単位として列挙し、
  * 通貨生成時のパターンとして使用する。
  */
sealed trait MyCurrency

/**
  * 通貨を生成する
  */
object MyCurrency {

  /**
    * 通貨単位：USDを示すシングルトンオブジェクト
    */
  case object USD extends MyCurrency

  /**
    * 通貨単位：CHFを示すシングルトンオブジェクト
    */
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
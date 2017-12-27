package example

sealed trait MyCurrency

/**
  * 通貨を生成する
  */
object MyCurrency {

  /** 通貨の定義 **/
  // Dollar
  case object DollarCurrency extends MyCurrency
  // Franc
  case object FrancCurrency extends MyCurrency

  def apply(amount: Int)(implicit currency: MyCurrency): Money =
    currency match {
      case DollarCurrency => Dollar(amount)
      case FrancCurrency => Franc(amount)
    }
}
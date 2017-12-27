package example

sealed trait MyCurrencyUnit

/**
  * 通貨単位
  */
object MyCurrencyUnit {

  /** 通貨単位の定義 **/
  // Dollar
  case object USD extends MyCurrencyUnit
  // Franc
  case object CHF extends MyCurrencyUnit
}
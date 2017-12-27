package example

import org.scalatest._

class MoneyTest extends FlatSpec with Matchers {

  "$5 * N times" should "be $5 * N" in {

    // Dollar
    implicit val myCurrency: MyCurrencyUnit = MyCurrencyUnit.USD

    val five: Money = MyCurrency(5)
    five.times(2) shouldEqual MyCurrency(10)
    five.times(3) shouldEqual MyCurrency(15)
  }

  "$N" should "be $N" in {

    // Dollar
    implicit val myCurrency: MyCurrencyUnit = MyCurrencyUnit.USD

    MyCurrency(5) shouldEqual MyCurrency(5)
    MyCurrency(5) should not be MyCurrency(6)
  }

  "$N" should "not be N CHF" in {
    MyCurrency(5)(MyCurrencyUnit.CHF) should not be
      MyCurrency(5)(MyCurrencyUnit.USD)
  }

  "Some Currency Unit" should "be equal to same Currency Unit" in {

    MyCurrencyUnit.USD shouldEqual
      MyCurrency(1)(MyCurrencyUnit.USD).currencyUnit

    MyCurrencyUnit.CHF shouldEqual
      MyCurrency(1)(MyCurrencyUnit.CHF).currencyUnit
  }

  "Different objects with same amount " should "be equal" in {
    MyCurrency(5)(MyCurrencyUnit.USD) shouldEqual
      MyCurrency(5)(MyCurrencyUnit.USD)

    MyCurrency(5)(MyCurrencyUnit.USD) should not be
      MyCurrency(6)(MyCurrencyUnit.USD)

    MyCurrency(5)(MyCurrencyUnit.CHF) should not be
      MyCurrency(5)(MyCurrencyUnit.USD)
  }

}

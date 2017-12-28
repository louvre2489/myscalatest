package example

import org.scalatest._

class MoneyTest extends FlatSpec with Matchers {

  // Dollar
  val dollar: MyCurrency = MyCurrency.USD

  // Franc
  val franc: MyCurrency = MyCurrency.CHF

  "$5 * N times" should "be $5 * N" in {

    val five: Money = MyCurrency(dollar)(5)
    five.times(2) shouldEqual MyCurrency(dollar)(10)
    five.times(3) shouldEqual MyCurrency(dollar)(15)
  }

  "$N" should "be $N" in {

    MyCurrency(dollar)(5) shouldEqual MyCurrency(dollar)(5)
    MyCurrency(dollar)(5) should not be MyCurrency(dollar)(6)
  }

  "$N" should "not be N CHF" in {
    MyCurrency(franc)(5) should not be
      MyCurrency(dollar)(5)
  }

  "Some Currency Unit" should "be equal to same Currency Unit" in {

    dollar shouldEqual
      MyCurrency(dollar)(1).currencyUnit

    franc shouldEqual
      MyCurrency(franc)(1).currencyUnit
  }

  "Different objects with same amount " should "be equal" in {
    MyCurrency(dollar)(5) shouldEqual
      MyCurrency(dollar)(5)

    MyCurrency(dollar)(5) should not be
      MyCurrency(dollar)(6)

    MyCurrency(franc)(5) should not be
      MyCurrency(dollar)(5)
  }

}

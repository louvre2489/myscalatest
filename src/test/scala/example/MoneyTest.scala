package example

import org.scalatest._

class MoneyTest extends FlatSpec with Matchers {

  "$5 * N times" should "be $5 * N" in {

    // Dollar
    implicit val myCurrency: MyCurrency = MyCurrency.DollarCurrency

    val five: Money = MyCurrency(5)
    five.times(2) shouldEqual MyCurrency(10)
    five.times(3) shouldEqual MyCurrency(15)
  }

  "$N" should "be $N" in {

    // Dollar
    implicit val myCurrency: MyCurrency = MyCurrency.DollarCurrency

    MyCurrency(5) shouldEqual MyCurrency(5)
    MyCurrency(5) should not be MyCurrency(6)
  }

  "N CHF" should "be N CHF" in {

    // Franc
    implicit val myCurrency: MyCurrency = MyCurrency.FrancCurrency

    MyCurrency(5) shouldEqual MyCurrency(5)
    MyCurrency(5) should not be MyCurrency(6)
  }

  "$N" should "not be N CHF" in {
    MyCurrency(5)(MyCurrency.FrancCurrency) should not be MyCurrency(5)(MyCurrency.DollarCurrency)
  }

  // testFrancMultiplicationに相当
  "5 CHF * N times" should "be 5 CHF * N" in {

    // Franc
    implicit val myCurrency: MyCurrency = MyCurrency.FrancCurrency

    val five: Money = MyCurrency(5)
    five.times(2) shouldEqual MyCurrency(10)
    five.times(3) shouldEqual MyCurrency(15)
  }

}

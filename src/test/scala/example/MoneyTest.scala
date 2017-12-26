package example

import org.scalatest._

class MoneyTest extends FlatSpec with Matchers {

  "$5 * N times" should "be $5 * N" in {
    val five: Dollar = Dollar(5)
    five.times(2) shouldEqual Dollar(10)
    five.times(3) shouldEqual Dollar(15)
  }

  "$N" should "be $N" in {
    Dollar(5) shouldEqual Dollar(5)
    Dollar(5) should not be Dollar(6)
  }

  "N CHF" should "be N CHF" in {
    Franc(5) shouldEqual Franc(5)
    Franc(5) should not be Franc(6)
  }

  "$N" should "not be N CHF" in {
    Franc(5) should not be Dollar(5)
  }

  "5 CHF * N times" should "be 5 CHF * N" in {
    val five: Franc = Franc(5)
    five.times(2) shouldEqual Franc(10)
    five.times(3) shouldEqual Franc(15)
  }

}

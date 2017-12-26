package example

import org.scalatest._

class MoneyTest extends FlatSpec with Matchers {

  "$5 * N times" should "be $5 * N" in {
    val five: Dollar = Dollar(5)
    five.times(2)
    five.amount shouldEqual 10
  }

}

package example

import org.scalatest._

class MoneyTest extends FlatSpec with Matchers {

  "$5 * N times" should "be $5 * N" in {
    val five: Dollar = Dollar(5)
    var product: Dollar = five.times(2)
    product.amount shouldEqual 10
    product = five.times(3)
    product.amount shouldEqual 15
  }

  "$5" should "be $5" in {
    Dollar(5) shouldEqual  Dollar(5)
    Dollar(5) should not be Dollar(6)
  }

}

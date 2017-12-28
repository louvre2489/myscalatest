package example

import java.beans.Expression

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

  "Different objects with same amount " should "be equal" in {
    MyCurrency(dollar)(5) shouldEqual
      MyCurrency(dollar)(5)

    MyCurrency(dollar)(5) should not be
      MyCurrency(dollar)(6)

    MyCurrency(franc)(5) should not be
      MyCurrency(dollar)(5)
  }

  "Some Currency Unit" should "be equal to same Currency Unit" in {

    dollar shouldEqual
      MyCurrency(dollar)(1).currencyUnit

    franc shouldEqual
      MyCurrency(franc)(1).currencyUnit
  }

  "$5 + $5" should "be $10" in {

    val five: Money = MyCurrency(dollar)(5)
    val sum: Expression = five plus five
    val bank: Bank = new Bank()

    val reduced: Money = bank reduce(sum, MyCurrency.USD)
    MyCurrency(dollar)(10) shouldEqual reduced
  }

  "Result of Calculation" should "be Money Object" in {

    val five: Money = MyCurrency(dollar)(5)
    val result: Expression = five plus five
    val sum: Sum = result.asInstanceOf[Sum]

    five shouldEqual sum.augend
    five shouldEqual sum.addend
  }

  "Reduce Money(3) and Money(4)" should "be Money(7)" in {

    val sum: Expression = Sum(MyCurrency(dollar)(3), MyCurrency(dollar)(4))
    val bank = new Bank()

    val result: Money = bank.reduce(sum, MyCurrency.USD)
    MyCurrency(dollar)(7) shouldEqual result
  }

  "Reduce only Money(1)" should "be Money(1)" in {

    val bank: Bank = new Bank()
    val result: Money = bank.reduce(MyCurrency(dollar)(1), MyCurrency.USD)

    MyCurrency(dollar)(1) shouldEqual result
  }

}

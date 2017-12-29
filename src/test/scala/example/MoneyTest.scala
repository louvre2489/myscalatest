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
    reduced shouldEqual MyCurrency(dollar)(10)
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
    result shouldEqual MyCurrency(dollar)(7)
  }

  "Reduce only Money(1)" should "be Money(1)" in {

    val bank: Bank = new Bank()
    val result: Money = bank.reduce(MyCurrency(dollar)(1), MyCurrency.USD)

    result shouldEqual MyCurrency(dollar)(1)
  }

  "Different Currency" can "be reduced" in {

    val bank: Bank = new Bank()
    bank.addRate(MyCurrency.CHF, MyCurrency.USD, 2)
    val result: Money = bank.reduce(MyCurrency(franc)(2), MyCurrency.USD)

    result shouldEqual MyCurrency(dollar)(1)

  }

  "Rate of Same Currency" should "be 1" in {
    val bank: Bank = new Bank()
    bank.rate(MyCurrency.USD, MyCurrency.USD) shouldEqual 1
  }

  "Mixed currency addition" should "be able" in {

    val fiveBucks: Expression = MyCurrency(dollar)(5)
    val tenFrancs: Expression = MyCurrency(franc)(10)

    val bank = new Bank()
    bank.addRate(MyCurrency.CHF, MyCurrency.USD, 2)

    val result: Money = bank.reduce((fiveBucks plus tenFrancs), MyCurrency.USD)
    result shouldEqual MyCurrency(dollar)(10)
  }

}

package lab9

object Q1 {
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator cannot be zero")

    val gcdValue: Int = gcd(n, d)
    val numer: Int = n / gcdValue
    val denom: Int = d / gcdValue

    override def toString: String = {
      if (denom < 0) {
        s"-${numer.abs}/${denom.abs}"
      } else {
        s"$numer/${denom.abs}"
      }
    }

    def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    def neg: Rational = new Rational(-numer, denom)
  }

  def main(args: Array[String]): Unit = {
    val rational1 = new Rational(9, 15)
    val negRational1 = rational1.neg
    println(s"Original : $rational1")
    println(s"Negation : $negRational1")
  }
}

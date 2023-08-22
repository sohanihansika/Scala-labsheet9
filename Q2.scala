package lab9

object Q2 {
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

    def sub(other: Rational): Rational = {
      new Rational(numer * other.denom - other.numer * denom, denom * other.denom)
    }
  }

  def main(args: Array[String]): Unit = {

    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result = x.sub(y).sub(z)

    println(s"x = $x")
    println(s"y = $y")
    println(s"z = $z")
    println(s"x - y - z = $result")
  }

}

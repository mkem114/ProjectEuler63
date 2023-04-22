import java.math.BigInteger

fun main() {
    // base probably can't be more than 10, because nth power is always 1 less than n-digits, e.g. 10^2 is 3-digits
    // 0 is generally not positive nor negative
    // results of positive bases should be a superset of negative bases' results that are positive
    val nDigitPositiveIntegers = mutableSetOf<BigInteger>()
    for (base in 1..9L) {
        // maybe there's no cap on exponents, but we'll track exponents going faster than digits, and hopefully this
        // a limit big enough
        (1..1_000).forEach { exponent ->
            val number = power(BigInteger.valueOf(base), exponent)
            if (numDigits(number) == exponent) {
                nDigitPositiveIntegers.add(number)
            } else {
                return@forEach
            }
        }
    }

    println(nDigitPositiveIntegers)
    println(nDigitPositiveIntegers.size)
}

fun power (base: BigInteger, exponent: Int): BigInteger {
    var working = base
    (2..exponent).forEach { _ ->
        working = working.multiply(base)
    }

    return working
}

fun numDigits (num: BigInteger): Int = num.toString().length
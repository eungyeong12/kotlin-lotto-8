package lotto.domain

class FixedNumbersProvider(private val numbers: List<Int>): NumbersProvider {
    override fun pick() = numbers
}
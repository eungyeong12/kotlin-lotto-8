package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(
    val result: Map<Rank, Int>
){
    fun calculateProfit(amount: Amount): Double {
        val total = calculateTotalPrize()
        return total.multiply(100.toBigDecimal())
            .divide(amount.value.toBigDecimal(), 1, RoundingMode.HALF_UP)
            .toDouble()
    }

    private fun calculateTotalPrize(): BigDecimal {
        return result.map { (rank, count) ->
            rank.calculatePrize(count)
        }.sumOf { it }
    }
}
package lotto.domain

import java.math.BigDecimal

class LottoResult(
    val result: Map<Rank, Int>
){
    fun calculateProfit(amount: Amount): Double {
        val total = calculateTotalPrize()
        return total.divide(amount.value.toBigDecimal()).toDouble()
    }

    private fun calculateTotalPrize(): BigDecimal {
        return result.map { (rank, count) ->
            rank.calculatePrize(count)
        }.sumOf { it }
    }
}
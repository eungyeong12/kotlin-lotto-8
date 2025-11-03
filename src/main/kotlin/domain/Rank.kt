package domain

import java.math.BigDecimal

enum class Rank(val matchCount: Int = 0, val isBonusNumberMatch: Boolean = false, val prize: Int = 0) {
    THREE_MATCH(matchCount = 3, prize = 5_000),
    FOUR_MATCH(matchCount = 4, prize = 50_000),
    FIVE_MATCH(matchCount = 5, isBonusNumberMatch = false, prize = 1_500_000),
    FIVE_MATCH_AND_BONUS_MATCH(matchCount = 5, isBonusNumberMatch = true, prize = 30_000_000),
    SIX_MATCH(matchCount = 6, prize = 2_000_000_000),
    ELSE;

    fun culculatePrize(count: Int): BigDecimal {
        return prize.toBigDecimal().multiply(count.toBigDecimal())
    }

    companion object {
        fun from(matchCount: Int, isBonusNumberMatch: Boolean): Rank {
            if (matchCount == 5) {
                return entries.firstOrNull {
                    it.matchCount == matchCount && it.isBonusNumberMatch == isBonusNumberMatch
                } ?: ELSE
            }
            return entries.firstOrNull() { it.matchCount == matchCount } ?: ELSE
        }
    }
}
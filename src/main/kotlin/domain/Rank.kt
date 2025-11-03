package domain

import java.math.BigDecimal

enum class Rank(val matchCount: Int = 0, val isBonusNumberMatch: Boolean = false, val prize: Int = 0) {
    THREE_MATCH(3, false, 5_000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH(matchCount = 5, false, 1_500_000),
    FIVE_MATCH_AND_BONUS_MATCH(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000),
    NONE(0, false, 0);

    fun calculatePrize(count: Int): BigDecimal {
        return prize.toBigDecimal() * count.toBigDecimal()
    }

    companion object {
        fun from(matchCount: Int, isBonusNumberMatch: Boolean): Rank {
            return entries.firstOrNull {
                it.matchCount == matchCount && it.isBonusNumberMatch == isBonusNumberMatch
            } ?: entries.firstOrNull { it.matchCount == matchCount } ?: NONE
        }
    }
}
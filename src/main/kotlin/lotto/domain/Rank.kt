package lotto.domain

import java.math.BigDecimal

enum class Rank(val prize: Long) {
    FIRST( 2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NONE(0);

    fun getPrize(count: Int): BigDecimal {
        return prize.toBigDecimal() * count.toBigDecimal()
    }

    companion object {
        fun from(match: Int, bonusMatch: Boolean): Rank =
            when (match) {
                6 -> FIRST
                5 if bonusMatch -> SECOND
                5 -> FOURTH
                4 -> THIRD
                3 -> FIFTH
                else -> NONE
            }
    }
}
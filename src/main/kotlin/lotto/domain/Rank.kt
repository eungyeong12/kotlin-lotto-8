package lotto.domain

enum class Rank(
    val matchCount: Int,
    val prize: Int
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    fun calculatePrize(count: Int) = prize.toBigDecimal() * count.toBigDecimal()

    companion object {
        fun from(matchCount: Int, bonusMatch: Boolean) =
            when (matchCount) {
                6 -> FIRST
                5 if bonusMatch -> SECOND
                5 -> THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> NONE
            }
    }
}
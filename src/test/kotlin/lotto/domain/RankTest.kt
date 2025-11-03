package lotto.domain

import domain.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal
import java.util.stream.Stream

@DisplayName("당첨 내역 테스트")
class RankTest {

    @ParameterizedTest(name = "당첨 번호 일치 개수: {0}, 보너스 일치 여부: {1}, 결과: {2}")
    @MethodSource("provideInputAndRank")
    fun `당첨 번호 일치 개수와 보너스 일치 여부에 대해 올바른 결과를 반환한다`(
        matchCount: Int,
        isBonusNumberMatch: Boolean,
        actual: Rank
    ) {
        // when
        val rank = Rank.from(matchCount, isBonusNumberMatch)

        // then
        assertEquals(rank, actual)
    }

    @ParameterizedTest(name = "입력: {0}, 결과: {1}")
    @MethodSource("provideInputAndPrize")
    fun `Rank와 일치 개수에 대해 올바른 당첨 금액을 반환한다`(
        rank: Rank,
        count: Int,
        actual: BigDecimal
    ) {
        // when
        val prize = rank.culculatePrize(count)

        // then
        assertEquals(prize, actual)
    }

    companion object {
        @JvmStatic
        fun provideInputAndRank(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(3, false, Rank.THREE_MATCH),
                Arguments.of(3, true, Rank.THREE_MATCH),
                Arguments.of(4, false, Rank.FOUR_MATCH),
                Arguments.of(4, true, Rank.FOUR_MATCH),
                Arguments.of(5, false, Rank.FIVE_MATCH),
                Arguments.of(5, true, Rank.FIVE_MATCH_AND_BONUS_MATCH),
                Arguments.of(6, false, Rank.SIX_MATCH),
                Arguments.of(6, true, Rank.SIX_MATCH)
            )
        }

        @JvmStatic
        fun provideInputAndPrize(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Rank.THREE_MATCH, 3, 15_000.toBigDecimal()),
                Arguments.of(Rank.FOUR_MATCH, 2, 100_000.toBigDecimal()),
                Arguments.of(Rank.FIVE_MATCH, 2, 3_000_000.toBigDecimal())
            )
        }
    }
}

package lotto.domain

import domain.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FixedLottoNumberGenerator(private val numbers: List<Int>): LottoNumberGenerator {
    override fun generate() = numbers
}

@DisplayName("로또 발행 및 결과 반환 테스트")
class LottosTest {

    @Test
    fun `금액과 LottoNumberGenerator를 입력받아 정상적으로 로또를 발행한다`() {
        // given
        val amount = Amount.from("10000")

        // when
        val lottos = Lottos.generate(
            amount,
            FixedLottoNumberGenerator(listOf(6, 5, 4, 3, 2, 1))
        ).toDto()

        // then
        assertEquals(lottos.count, 10)
        assertEquals(lottos.lottos[0].numbers, listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `당첨 번호 일치 개수와 보너스 일치 여부에 대해 올바른 당첨 내역을 반환한다`() {
        // given
        val lottos = Lottos.generate(
            Amount.from("2000"),
            FixedLottoNumberGenerator(listOf(1, 2, 3, 4, 5, 6))
        )
        val winningNumbers = WinningNumbers.from("1, 2, 3, 7, 8, 9")
        val bonusNumber = BonusNumber.from("10", winningNumbers)

        // when
        val results = lottos.getWinningResults(winningNumbers, bonusNumber)

        // then
        assertEquals(results[Rank.THREE_MATCH], 2)
    }

    @Test
    fun `당첨 내역과 구입 금액에 대해 올바른 수익률을 반환한다`() {
        // given
        val amount = Amount.from("2000")
        val lottos = Lottos.generate(
            amount,
            FixedLottoNumberGenerator(listOf(1, 2, 3, 4, 5, 6))
        )
        val winningNumbers = WinningNumbers.from("1, 2, 3, 7, 8, 9")
        val bonusNumber = BonusNumber.from("10", winningNumbers)
        val results = lottos.getWinningResults(winningNumbers, bonusNumber)

        // when
        val rate = lottos.getRateOfReturn(results, amount)

        // then
        assertEquals(rate, 5.0.toBigDecimal())
    }
}
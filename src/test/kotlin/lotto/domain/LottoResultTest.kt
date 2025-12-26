package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `당첨 결과와 구입 금액을 바탕으로 수익률을 올바르게 계산한다`() {
        // given
        val amount = Amount.from("1000")
        val numbersProvider = FixedNumbersProvider(listOf(1, 2, 3, 4, 5, 6))
        val lottoMachine = LottoMachine.generateLotto(amount, numbersProvider)
        val winningNumber = WinningNumber.from("1, 2, 3, 14, 15, 16")
        val bonusNumber = BonusNumber.from("7", winningNumber)
        val result = LottoResult(lottoMachine.getRanks(winningNumber, bonusNumber))

        // when
        val profit = result.calculateProfit(amount)
        println(profit)

        // then
        assertEquals(profit, 500.0)
    }
}
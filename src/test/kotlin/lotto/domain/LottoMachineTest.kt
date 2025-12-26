package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `정상적인 입력이 들어오면, 구입 금액만큼 로또를 생성한다`() {
        // given
        val amount = Amount.from("10000")
        val numbersProvider = FixedNumbersProvider(listOf(1, 2, 3, 4, 5, 6))

        // when
        val lottoMachine = LottoMachine.generateLotto(amount, numbersProvider)
        val purchasedLotto = lottoMachine.getPurchasedLotto()

        // then
        assertEquals(purchasedLotto.count, 10)
    }

    @Test
    fun `당첨 번호와 보너스 번호가 주어지면, 정상적인 당쳠 결과를 반환한다`() {
        // given
        val amount = Amount.from("10000")
        val numbersProvider = FixedNumbersProvider(listOf(1, 2, 3, 4, 5, 6))
        val lottoMachine = LottoMachine.generateLotto(amount, numbersProvider)
        val winningNumber = WinningNumber.from("2, 3, 4, 5, 6, 7")
        val bonusNumber = BonusNumber.from("1", winningNumber)

        // when
        val result = lottoMachine.getRanks(winningNumber, bonusNumber)

        // then
        assertEquals(result[Rank.SECOND], 10)
    }
}
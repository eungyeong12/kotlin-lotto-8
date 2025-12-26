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
        val lottoes = LottoMachine.generateLotto(amount, numbersProvider).lottoes

        // then
        assertEquals(lottoes.size, 10)
    }
}
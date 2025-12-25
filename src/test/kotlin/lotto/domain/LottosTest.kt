package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    fun `정상적인 입력이 들어오면, 구입 금액만큼 Lotto 리스트를 만들어낸다`() {
        // given
        val amount = Amount.from("10000")
        val numbersProvider = FixedNumbersProvider(listOf(1, 2, 3, 4, 5, 6))

        // when
        val lottos = Lottos.from(amount, numbersProvider).lottos

        // then
        assertEquals(lottos.size, 10)
    }
}
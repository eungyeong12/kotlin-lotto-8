package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `당첨 번호가 주어지면, 로또 번호와 일치하는 당첨 번호의 개수를 올바르게 반환한다`() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumber = listOf(1, 2, 3, 4, 8, 9)

        // when
        val count = lotto.matchCount(winningNumber)

        // then
        assertEquals(count, 4)
    }
}
package lotto.domain

import exception.ErrorMessage
import lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("로또 테스트")
class LottoTest {

    @Test
    fun `6개의 숫자가 입력되지 않는 경우 IllegalArgumentException이 발생한다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5)

        // when
        val exception = assertThrows<IllegalArgumentException> { Lotto(numbers) }

        // then
        assertEquals(exception.message, ErrorMessage.LOTTO_NUMBER_COUNT_INVALID.toString())
    }
}
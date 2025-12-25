package lotto.domain

import lotto.exception.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {

    @Test
    fun `정상적인 입력이 들어올 경우, WinningNumber 객체가 생성된다`() {
        // given
        val input = "1, 2, 3, 4, 5, 6"

        // when
        val winningNumber = WinningNumber.from(input).value

        // then
        assertEquals(winningNumber.size, 6)
        assertEquals(winningNumber, listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `입력이 비어 있을 경우, 에러 메시지가 던져진다`() {
        // given
        val input = ""

        // when
        val exception = assertThrows<IllegalArgumentException> { WinningNumber.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.BLANK_WINNING_NUMBER_INPUT.toString())
    }

    @Test
    fun `정수가 아닌 번호가 있을 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "1, 2, a, 4, 5, 6"

        // when
        val exception = assertThrows<IllegalArgumentException> { WinningNumber.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.WINNING_NUMBER_NOT_INTEGER.toString())
    }

    @Test
    fun `1~45의 범위가 아닌 번호가 있을 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "1, 2, 3, 4, 5, 66"

        // when
        val exception = assertThrows<IllegalArgumentException> { WinningNumber.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.WRONG_RANGE_WINNING_NUMBER.toString())
    }

    @Test
    fun `당첨 번호가 6개가 아닌 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "1, 2, 3, 4, 5"

        // when
        val exception = assertThrows<IllegalArgumentException> { WinningNumber.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.WINNING_NUMBER_NOT_SIX.toString())
    }

    @Test
    fun `중복된 번호가 있을 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "1, 2, 3, 4, 5, 5"

        // when
        val exception = assertThrows<IllegalArgumentException> { WinningNumber.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.DUPLICATE_WINNING_NUMBER.toString())
    }
}
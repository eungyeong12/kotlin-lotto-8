package lotto.domain

import lotto.exception.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    @Test
    fun `정상적인 입력이 들어올 경우, BonusNumber 객체가 생성된다`() {
        // given
        val winningNumber = WinningNumber.from("1, 2, 3, 4, 5, 6")
        val input = "7"

        // when
        val bonusNumber = BonusNumber.from(input, winningNumber).value

        // then
        assertEquals(bonusNumber, 7)
    }

    @Test
    fun `입력이 비어 있을 경우, 에러 메시지가 던져진다`() {
        // given
        val winningNumber = WinningNumber.from("1, 2, 3, 4, 5, 6")
        val input = ""

        // when
        val exception = assertThrows<IllegalArgumentException> { BonusNumber.from(input, winningNumber) }

        // then
        assertEquals(exception.message, ErrorMessage.BLANK_BONUS_NUMBER.toString())
    }

    @Test
    fun `입력이 정수가 아닐 경우, 에러 메시지가 던져진다`() {
        // given
        val winningNumber = WinningNumber.from("1, 2, 3, 4, 5, 6")
        val input = "a"

        // when
        val exception = assertThrows<IllegalArgumentException> { BonusNumber.from(input, winningNumber) }

        // then
        assertEquals(exception.message, ErrorMessage.BONUS_NUMBER_NOT_INTEGER.toString())
    }

    @Test
    fun `입력이 1~45의 범위가 아닐 경우, 에러 메시지가 던져진다`() {
        // given
        val winningNumber = WinningNumber.from("1, 2, 3, 4, 5, 6")
        val input = "100"

        // when
        val exception = assertThrows<IllegalArgumentException> { BonusNumber.from(input, winningNumber) }

        // then
        assertEquals(exception.message, ErrorMessage.WRONG_RANGE_BONUS_NUMBER.toString())
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되는 경우, 에러 메시지가 던져진다`() {
        // given
        val winningNumber = WinningNumber.from("1, 2, 3, 4, 5, 6")
        val input = "6"

        // when
        val exception = assertThrows<IllegalArgumentException> { BonusNumber.from(input, winningNumber) }

        // then
        assertEquals(exception.message, ErrorMessage.DUPLICATE_BONUS_NUMBER.toString())
    }
}
package lotto.domain

import lotto.exception.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AmountTest {

    @Test
    fun `정상적인 입력이 들어올 경우, Amount 객체가 생성된다`() {
        // given
        val input = "10000"

        // when
        val amount = Amount.from(input).value

        // then
        assertEquals(amount, 10000)
    }

    @Test
    fun `입력이 비어 있을 경우, 에러 메시지가 던져진다`() {
        // given
        val input = ""

        // when
        val exception = assertThrows<IllegalArgumentException> { Amount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.BLANK_AMOUNT_INPUT.errorMessage)
    }

    @Test
    fun `입력이 정수가 아닐 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "a"

        // when
        val exception = assertThrows<IllegalArgumentException> { Amount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.AMOUNT_NOT_INTEGER.errorMessage)
    }

    @Test
    fun `입력이 1000원 이상이 아닐 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "500"

        // when
        val exception = assertThrows<IllegalArgumentException> { Amount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.AMOUNT_LESS_THAN_THOUSAND.errorMessage)
    }

    @Test
    fun `입력이 1000원 단위가 아닐 경우, 에러 메시지가 던져진다`() {
        // given
        val input = "1200"

        // when
        val exception = assertThrows<IllegalArgumentException> { Amount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.AMOUNT_NOT_THOUSAND_UNIT.errorMessage)
    }
}
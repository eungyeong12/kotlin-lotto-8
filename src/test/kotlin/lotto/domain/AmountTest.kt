package lotto.domain

import domain.Amount
import exception.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("로또 금액 테스트")
class AmountTest {

    @Test
    fun `천 원단위의 정상적인 금액이 입력되면 금액 객체가 생성된다`() {
        // given
        val input = "10000"

        // when
        val amount = Amount.from(input)

        // then
        assertEquals(10000, amount.value)
    }

    @Test
    fun `구입 금액이 비어 있다면 IllegalArgumentException이 발생한다`() {
        // given
        val input = ""

        // when
        val exception = assertThrows<IllegalArgumentException> { Amount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.AMOUNT_BLANK.toString())
    }

    @Test
    fun `구입 금액이 정수가 아니라면 IllegalArgumentException이 발생한다`() {
        // given
        val input = "abc"

        // when
        val exception = assertThrows<IllegalArgumentException> { Amount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.AMOUNT_NOT_INTEGER.toString())
    }

    @Test
    fun `구입 금액이 양수가 아니라면 IllegalArgumentException이 발생한다`() {
        // given
        val input = "-1"

        // when
        val exception = assertThrows<IllegalArgumentException> { Amount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.AMOUNT_BELOW_MINIMUM.toString())
    }

    @Test
    fun `구입 금액이 1000원 단위가 아니라면 IllegalArgumentException이 발생한다`() {
        // given
        val input = "1111"

        // when
        val exception = assertThrows<IllegalArgumentException> { Amount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.AMOUNT_NOT_THOUSAND_UNIT.toString())
    }
}

package lotto.domain

import domain.WinningNumbers
import exception.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("당첨 번호 테스트")
class WinningNumbersTest {

    @Test
    fun `쉼표로 구분된 6개의 숫자를 입력하면 당첨 번호 객체가 생성된다`() {
        // given
        val input = "1, 2, 3, 4, 5, 6"

        // when
        val winningNumbers = WinningNumbers.from(input)

        // then
        assertEquals(listOf(1, 2, 3, 4, 5, 6), winningNumbers.value)
    }

    @Test
    fun `입력이 비어 있다면 IllegalArgumentException이 발생한다`() {
        // given
        val input = ""

        // when
        val exception = assertThrows<IllegalArgumentException> { WinningNumbers.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.INPUT_BLANK.toString())
    }

    @Test
    fun `정수가 아닌 값이 있다면 IllegalArgumentException이 발생한다`() {
        // given
        val input = "a, 1, 2, 3, 4, 5"

        // when
        val exception = assertThrows<IllegalArgumentException> { WinningNumbers.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.INPUT_NOT_INTEGER.toString())
    }

    @Test
    fun `6개의 값이 존재하지 않는다면 IllegalArgumentException이 발생한다`() {
        // given
        val input = "1, 2, 3, 4, 5"

        // when
        val exception = assertThrows<IllegalArgumentException> { WinningNumbers.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.LOTTO_NUMBER_COUNT_INVALID.toString())
    }

    @Test
    fun `1부터 45 사이의 숫자가 아닌 값이 있다면 IllegalArgumentException이 발생한다`() {
        // given
        val input = "-1, 1, 2, 3, 4, 5"

        // when
        val exception = assertThrows<IllegalArgumentException> { WinningNumbers.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.LOTTO_NUMBERS_RANGE_INVALID.toString())
    }

    @Test
    fun `중복되는 숫자가 있다면 IllegalArgumentException이 발생한다`() {
        // given
        val input = "1, 1, 2, 3, 4, 5"

        // when
        val exception = assertThrows<IllegalArgumentException> { WinningNumbers.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.LOTTO_NUMBERS_DUPLICATE.toString())
    }

    @Test
    fun `사용자가 구매한 로또 번호와 당첨 번호를 비교하여 올바르게 일치 개수를 반환한다`() {
        // given
        val winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6")
        val lottoNumbers = listOf(1, 2, 3, 8, 9, 10)

        // when
        val matchCount = winningNumbers.getMatchCount(lottoNumbers)

        // then
        assertEquals(matchCount, 3)
    }
}
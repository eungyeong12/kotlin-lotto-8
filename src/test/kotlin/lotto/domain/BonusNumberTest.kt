package lotto.domain

import domain.BonusNumber
import domain.WinningNumbers
import exception.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("보너스 번호 테스트")
class BonusNumberTest {

    @Test
    fun `당첨 번호와 중복되지 않는 1부터 45사이의 숫자가 입력되면 보너스 번호 객체가 생성된다`() {
        // given
        val winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6")
        val input = "7"

        // when
        val bonusNumber = BonusNumber.from(input, winningNumbers)

        // then
        assertEquals(7, bonusNumber.value)
    }

    @Test
    fun `입력이 비어 있다면 IllegalArgumentException이 발생한다`() {
        // given
        val winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6")
        val input = ""

        // when
        val exception = assertThrows<IllegalArgumentException> { BonusNumber.from(input, winningNumbers) }

        // then
        assertEquals(exception.message, ErrorMessage.INPUT_BLANK.toString())
    }

    @Test
    fun `입력값이 정수가 아니라면 IllegalArgumentException이 발생한다`() {
        // given
        val winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6")
        val input = "a"

        // when
        val exception = assertThrows<IllegalArgumentException> { BonusNumber.from(input, winningNumbers) }

        // then
        assertEquals(exception.message, ErrorMessage.INPUT_NOT_INTEGER.toString())
    }

    @Test
    fun `입력값이 1부터 45 사이의 숫자가 아니라면 IllegalArgumentException이 발생한다`() {
        // given
        val winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6")
        val input = "-1"

        // when
        val exception = assertThrows<IllegalArgumentException> { BonusNumber.from(input, winningNumbers) }

        // then
        assertEquals(exception.message, ErrorMessage.LOTTO_NUMBERS_RANGE_INVALID.toString())
    }

    @Test
    fun `입력값이 당첨 번호와 중복되는 숫자라면 IllegalArgumentException이 발생한다`() {
        // given
        val winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6")
        val input = "1"

        // when
        val exception = assertThrows<IllegalArgumentException> { BonusNumber.from(input, winningNumbers) }

        // then
        assertEquals(exception.message, ErrorMessage.LOTTO_NUMBERS_DUPLICATE.toString())
    }

    @Test
    fun `보너스 숫자가 로또 번호와 일치한다면 true를 반환한다`() {
        // given
        val winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6")
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 7)
        val bonus = BonusNumber.from("7", winningNumbers)

        // when
        val isBonusNumberMatch = bonus.isBonusNumberMatch(lottoNumbers)

        // then
        assertEquals(isBonusNumberMatch, true)
    }

    @Test
    fun `보너스 숫자가 로또 번호와 일치하지 않는다면 false를 반환한다`() {
        // given
        val winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6")
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = BonusNumber.from("7", winningNumbers)

        // when
        val isBonusNumberMatch = bonus.isBonusNumberMatch(lottoNumbers)

        // then
        assertEquals(isBonusNumberMatch, false)
    }
}
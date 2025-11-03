package lotto

import domain.BonusNumber
import domain.Rank
import domain.WinningNumbers
import exception.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

        // when
        val exception = assertThrows<IllegalArgumentException> { Lotto(numbers) }

        // then
        assertEquals(exception.message, ErrorMessage.LOTTO_NUMBER_COUNT_INVALID.toString())
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 4)

        // when
        val exception = assertThrows<IllegalArgumentException> { Lotto(numbers) }

        // then
        assertEquals(exception.message, ErrorMessage.LOTTO_NUMBERS_DUPLICATE.toString())
    }

    @Test
    fun `로또 번호에 1부터 45 사이의 범위가 아닌 숫자가 있으면 예외가 발생한다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 55)

        // when
        val exception = assertThrows<IllegalArgumentException> { Lotto(numbers) }

        // then
        assertEquals(exception.message, ErrorMessage.LOTTO_NUMBERS_RANGE_INVALID.toString())
    }

    @Test
    fun `당첨 번호 일치 개수와 보너스 일치 여부에 대해 올바른 결과를 반환한다`() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6")
        val bonusNumber = BonusNumber.from("7", winningNumbers)

        // when
        val rank = lotto.getRank(winningNumbers, bonusNumber)

        // then
        assertEquals(rank, Rank.FIVE_MATCH_AND_BONUS_MATCH)
    }
}

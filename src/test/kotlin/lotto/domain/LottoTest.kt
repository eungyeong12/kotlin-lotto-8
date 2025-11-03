package lotto.domain

import domain.BonusNumber
import domain.Rank
import domain.WinningNumbers
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
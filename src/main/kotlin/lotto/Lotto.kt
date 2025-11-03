package lotto

import constant.Constants.LOTTO_COUNT
import domain.BonusNumber
import domain.Rank
import domain.WinningNumbers
import domain.dto.LottoDto
import exception.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT) { ErrorMessage.LOTTO_NUMBER_COUNT_INVALID }
    }

    fun getRank(winningNumbers: WinningNumbers, bonusNumber: BonusNumber): Rank {
        return Rank.from(
            winningNumbers.getMatchCount(numbers),
            bonusNumber.isBonusNumberMatch(numbers)
        )
    }

    fun toDto(): LottoDto = LottoDto(numbers.sorted())
}

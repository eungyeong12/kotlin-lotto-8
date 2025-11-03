package lotto

import constant.Constants.LOTTO_COUNT
import constant.Constants.MAX_NUMBER
import constant.Constants.MIN_NUMBER
import domain.BonusNumber
import domain.Rank
import domain.WinningNumbers
import domain.dto.LottoDto
import exception.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT) { ErrorMessage.LOTTO_NUMBER_COUNT_INVALID }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { ErrorMessage.LOTTO_NUMBERS_RANGE_INVALID }
        require(numbers.size == numbers.distinct().size) { ErrorMessage.LOTTO_NUMBERS_DUPLICATE }
    }

    fun getRank(winningNumbers: WinningNumbers, bonusNumber: BonusNumber): Rank {
        return Rank.from(
            winningNumbers.getMatchCount(numbers),
            bonusNumber.isBonusNumberMatch(numbers)
        )
    }

    fun toDto(): LottoDto = LottoDto(numbers.sorted())
}

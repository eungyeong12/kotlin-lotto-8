package lotto

import domain.dto.LottoDto
import exception.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { ErrorMessage.LOTTO_NUMBER_COUNT_INVALID }
    }

    fun toDto(): LottoDto = LottoDto(numbers.sorted())

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}

package lotto

import constant.Constants.LOTTO_COUNT
import domain.dto.LottoDto
import exception.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT) { ErrorMessage.LOTTO_NUMBER_COUNT_INVALID }
    }

    fun toDto(): LottoDto = LottoDto(numbers.sorted())
}

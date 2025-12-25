package lotto.domain

import lotto.domain.dto.LottoDto
import lotto.exception.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessage.LOTTO_COUNT_NOT_SIX }
    }

    fun toDto() = LottoDto(numbers)
}
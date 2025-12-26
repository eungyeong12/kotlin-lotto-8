package lotto.domain

import lotto.domain.dto.LottoDto
import lotto.exception.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessage.LOTTO_COUNT_NOT_SIX }
    }

    fun matchCount(other: List<Int>): Int {
        return numbers.count { other.contains(it) }
    }

    fun contains(number: Int) = numbers.contains(number)

    fun toDto() = LottoDto(numbers)
}
package domain

import constant.Constants.AMOUNT_UNIT
import domain.dto.LottosDto
import lotto.Lotto

class Lottos private constructor(private val lottos: List<Lotto>) {

    fun getWinningResults(winningNumbers: WinningNumbers, bonusNumber: BonusNumber): Map<Rank, Int> {
        val results = lottos
            .map { it.getRank(winningNumbers, bonusNumber) }
            .groupingBy { it }
            .eachCount()
        return results.toMap()
    }

    fun toDto(): LottosDto =
        LottosDto(lottos.size, lottos.map { it.toDto() })

    companion object {
        fun generate(amount: Amount, lottoNumberGenerator: LottoNumberGenerator): Lottos {
            val count = amount.value / AMOUNT_UNIT
            val lottos = List(count) {
                Lotto(lottoNumberGenerator.generate())
            }
            return Lottos(lottos)
        }
    }
}

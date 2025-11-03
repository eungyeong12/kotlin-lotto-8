package domain

import constant.Constants.AMOUNT_UNIT
import domain.dto.LottosDto
import lotto.Lotto
import java.math.BigDecimal
import java.math.RoundingMode

class Lottos private constructor(private val lottos: List<Lotto>) {

    fun getWinningResults(winningNumbers: WinningNumbers, bonusNumber: BonusNumber): Map<Rank, Int> {
        val results = lottos
            .map { it.getRank(winningNumbers, bonusNumber) }
            .groupingBy { it }
            .eachCount()
        return results.toMap()
    }

    fun getRateOfReturn(results: Map<Rank, Int>, amount: Amount): BigDecimal {
        val totalPrize = results.entries
            .sumOf { (rank, count) ->  rank.culculatePrize(count) }

        return totalPrize.multiply(BigDecimal.valueOf(100))
            .divide(amount.value.toBigDecimal(), SCALE, RoundingMode.HALF_UP)
    }

    fun toDto(): LottosDto =
        LottosDto(lottos.size, lottos.map { it.toDto() })

    companion object {
        private const val SCALE = 1

        fun generate(amount: Amount, lottoNumberGenerator: LottoNumberGenerator): Lottos {
            val count = amount.value / AMOUNT_UNIT
            val lottos = List(count) {
                Lotto(lottoNumberGenerator.generate())
            }
            return Lottos(lottos)
        }
    }
}

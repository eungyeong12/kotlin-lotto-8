package domain

import domain.dto.LottosDto
import lotto.Lotto

class Lottos private constructor(private val lottos: List<Lotto>) {

    fun toDto(): LottosDto =
        LottosDto(lottos.size, lottos.map { it.toDto() })

    companion object {
        private const val AMOUNT_UNIT = 1000

        fun generate(amount: Amount, lottoNumberGenerator: LottoNumberGenerator): Lottos {
            val count = amount.value / AMOUNT_UNIT
            val lottos = List(count) {
                Lotto(lottoNumberGenerator.generate())
            }
            return Lottos(lottos)
        }
    }
}
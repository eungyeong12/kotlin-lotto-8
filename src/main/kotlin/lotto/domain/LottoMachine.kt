package lotto.domain

import lotto.constant.Constants.AMOUNT_UNIT
import lotto.domain.dto.PurchasedLotto

class LottoMachine private constructor(
    val lottoes: List<Lotto>
){
    fun toDto() = PurchasedLotto(
        lottoes.size,
        lottoes.map { it.toDto() }
    )

    companion object {
        fun generateLotto(amount: Amount, numbersProvider: NumbersProvider): LottoMachine {
            return LottoMachine(List(getLottoCount(amount)) {
                Lotto(numbersProvider.pick())
            })
        }

        private fun getLottoCount(amount: Amount): Int {
            return amount.value / AMOUNT_UNIT
        }
    }
}
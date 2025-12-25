package lotto.domain

import lotto.constant.Constants.AMOUNT_UNIT

class Lottos private constructor(
    val lottos: List<Lotto>
) {

    companion object {
        fun from(amount: Amount, numbersProvider: NumbersProvider): Lottos {
            return Lottos(List(getLottoCount(amount)) {
                Lotto(numbersProvider.pick())
            })
        }

        private fun getLottoCount(amount: Amount): Int {
            return amount.value / AMOUNT_UNIT
        }
    }
}
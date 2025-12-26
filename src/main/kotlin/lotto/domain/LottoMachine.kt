package lotto.domain

import lotto.constant.Constants.AMOUNT_UNIT
import lotto.domain.dto.PurchasedLotto

class LottoMachine private constructor(
    private val lottoes: List<Lotto>
){
    fun getRanks(winningNumber: WinningNumber, bonusNumber: BonusNumber): Map<Rank, Int> {
        return lottoes.map {
            Rank.from(
                it.matchCount(winningNumber.value),
                it.contains(bonusNumber.value)
            )
        }.groupingBy { it }.eachCount()
    }

    fun getPurchasedLotto() = PurchasedLotto(
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
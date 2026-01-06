package lotto.view

import lotto.domain.Lotto
import java.text.DecimalFormat

object OutputView {
    private val decimalFormat = DecimalFormat("#,###")

    fun printPurchasedLotto(purchasedLotto: List<Lotto>) {
        println()
        println("${purchasedLotto.size}개를 구매했습니다.")
        println(purchasedLotto.joinToString("\n") { it.getLotto().toString() })
        println()
    }

    fun printErrorMessage(errorMessage: String) {
        println()
        println(errorMessage)
        println()
    }
}
package lotto.view

import lotto.domain.Lotto
import lotto.domain.Rank
import java.math.BigDecimal
import java.text.DecimalFormat

object OutputView {
    val decimalFormat = DecimalFormat("#,##0.0")

    fun printPurchasedLotto(purchasedLotto: List<Lotto>) {
        println()
        println("${purchasedLotto.size}개를 구매했습니다.")
        println(purchasedLotto.joinToString("\n") { it.getLotto().toString() })
        println()
    }

    fun printResult(result: Map<Rank, Int>, profit: BigDecimal) {
        println()
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${result[Rank.FIFTH] ?: 0}개")
        println("4개 일치 (50,000원) - ${result[Rank.FOURTH] ?: 0}개")
        println("5개 일치 (1,500,000원) - ${result[Rank.THIRD] ?: 0}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[Rank.SECOND] ?: 0}개")
        println("6개 일치 (2,000,000,000원) - ${result[Rank.FIRST] ?: 0}개")
        println("총 수익률은 ${decimalFormat.format(profit)}%입니다.")
    }

    fun printErrorMessage(errorMessage: String) {
        println()
        println(errorMessage)
        println()
    }
}
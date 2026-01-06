package lotto.view

import java.text.DecimalFormat

object OutputView {
    private val decimalFormat = DecimalFormat("#,###")

    fun printErrorMessage(errorMessage: String) {
        println()
        println(errorMessage)
    }
}
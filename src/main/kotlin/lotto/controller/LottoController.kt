package lotto.controller

import lotto.domain.Amount
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        val amount = getAmount()
    }

    private fun getAmount(): Amount =
        executeWithRetry(
            { OutputView.displayAmountInputPrompt() },
        ) {
            Amount.from(InputView.readInput())
        }


    private fun <T> executeWithRetry(prompt: () -> Unit, block: () -> T): T {
        while (true) {
            try {
                prompt()
                return block()
            } catch (e: IllegalArgumentException) {
                OutputView.displayErrorMessage(e.message.toString())
            }
        }
    }
}
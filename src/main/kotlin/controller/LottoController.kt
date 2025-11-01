package controller

import domain.Amount
import view.InputView
import view.OutputView

class LottoController {
    fun run() {
        val amount = getPurchaseAmount()
    }
}

private fun getPurchaseAmount(): Amount {
    while (true) {
        try {
            OutputView.displayPurchaseAmountPrompt()
            return Amount.from(InputView.readInput())
        } catch (e: IllegalArgumentException) {
            println(e.message.toString())
        }
    }
}

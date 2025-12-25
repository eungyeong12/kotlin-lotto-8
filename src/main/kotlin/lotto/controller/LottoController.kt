package lotto.controller

import lotto.domain.Amount
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        OutputView.displayAmountInputPrompt()
        val amount = Amount.from(InputView.readInput())
    }
}
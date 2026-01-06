package lotto.controller

import lotto.domain.Lotto
import lotto.domain.RandomLottoNumberGenerator
import lotto.domain.Rank
import lotto.parser.Parser.parseToNumber
import lotto.parser.Parser.splitByDelimiter
import lotto.validator.Validator.validateNotBlank
import lotto.view.InputView
import lotto.view.OutputView
import java.math.RoundingMode

class LottoController {

    fun run() {
        val amount = getAmount()
        val lottoNumberGenerator = RandomLottoNumberGenerator()
        val purchasedLotto = Lotto.from(amount, lottoNumberGenerator)
        OutputView.printPurchasedLotto(purchasedLotto)

        val winningNumber = getWinningNumber()
        val bonusNumber = getBonusNumber(winningNumber)

        val result = purchasedLotto.map { lotto ->
            Rank.from(lotto.getMatchCount(winningNumber.getLotto()), lotto.contains(bonusNumber))
        }.groupingBy { it }.eachCount()

        val profit = result.map { (rank, count) -> rank.getPrize(count) }
            .sumOf { it }
            .multiply(100.toBigDecimal())
            .divide(amount.toBigDecimal(), 1, RoundingMode.HALF_UP)
    }

    private fun getAmount(): Int =
        executeWithRetry(
            { println("구입금액을 입력해 주세요.") },
        ) {
            val input = readNotBlankInput()
            val number = parseToNumber(input)
            require(number >= 1000) { "[ERROR] 로또 금액은 1,000원 이상이어야 합니다." }
            require(number % 1000 == 0) { "[ERROR] 로또 금액은 1,000원 단위여야 합니다." }
            number
        }

    private fun getWinningNumber(): Lotto =
        executeWithRetry(
            { println("당첨 번호를 입력해 주세요.") },
        ) {
            val input = readNotBlankInput()
            val tokens = splitByDelimiter(input, ',')
            val numbers = tokens.map { parseToNumber(it) }
            Lotto(numbers)
        }

    private fun getBonusNumber(winningNumber: Lotto): Int =
        executeWithRetry(
            { println("\n보너스 번호를 입력해 주세요.") },
        ) {
            val input = readNotBlankInput()
            val number = parseToNumber(input)
            require(number in 1..45) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
            require(!winningNumber.contains(number)) { "[ERROR] 로또 번호는 당첨 번호와 중복되지 않아야 합니다." }
            number
        }

    private fun <T> executeWithRetry(prompt: () -> Unit, block: () -> T): T {
        while (true) {
            try {
                prompt()
                return block()
            } catch (e: IllegalArgumentException) {
                OutputView.printErrorMessage(e.message.toString())
            }
        }
    }

    private fun readNotBlankInput(): String {
        val input = InputView.readInput()
        validateNotBlank(input)
        return input
    }
}
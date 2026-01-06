package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readInput(): String {
        return Console.readLine().trim()
    }
}
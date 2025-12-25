package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.Constants.LOTTO_COUNT
import lotto.constant.Constants.LOTTO_MAX_NUMBER
import lotto.constant.Constants.LOTTO_MIN_NUMBER

class RandomNumbersProvider: NumbersProvider {
    override fun pick(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_COUNT)
            .sorted()
    }
}
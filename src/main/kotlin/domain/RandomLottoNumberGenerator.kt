package domain

import camp.nextstep.edu.missionutils.Randoms
import constant.Constants.LOTTO_COUNT
import constant.Constants.MAX_NUMBER
import constant.Constants.MIN_NUMBER

class RandomLottoNumberGenerator: LottoNumberGenerator {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT)
    }
}

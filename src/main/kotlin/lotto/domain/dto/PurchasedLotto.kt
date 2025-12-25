package lotto.domain.dto

data class PurchasedLotto(
    val count: Int,
    val lottos: List<LottoDto>
)
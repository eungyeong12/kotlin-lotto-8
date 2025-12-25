package lotto.domain

interface NumbersProvider {
    fun pick(): List<Int>
}
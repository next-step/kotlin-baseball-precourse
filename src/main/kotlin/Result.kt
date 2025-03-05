data class Result(val strikes: Int, val balls: Int) {
    fun isCorrect(): Boolean {
        return strikes == 3
    }

    override fun toString(): String {
        return if (strikes == 0 && balls == 0) {
            "낫싱"
        } else {
            "${strikes}스트라이크 ${balls}볼"
        }
    }
}

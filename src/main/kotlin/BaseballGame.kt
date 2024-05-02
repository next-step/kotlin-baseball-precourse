class BaseballGame() {
    private val answer: String = this._createRandomAnswer()

    /** 서로 다른 임의의 3개의 숫자를 선택하여 정답을 생성하는 내부 함수
     *  @return 선택된 3개의 수를 이어 붙인 문자열 반환 */
    fun _createRandomAnswer(): String {
        // 1에서 9까지의 수를 List로 만들고, 이를 shuffle함 -> 같은 수가 선택되지 않음
        val shuffledList = (1..9).toList().shuffled()

        // 위에서 생성된 무작위의 수 중 앞의 3개만 골라서 다른 List로 저장
        val threeNumberList = shuffledList.subList(0, 3)

        // 3개의 Int가 들어간 List를 ""로 연결하여 문자열로 만들고, 반환
        return threeNumberList.joinToString("")
    }

}
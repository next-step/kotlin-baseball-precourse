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

    /** player의 입력과 정답을 비교하여 판정 값을 반환
     *  @return GameResult에 Ball개수와 Strike개수를 담아서 반환 */
    fun judgeGameResult(player: BaseballPlayer): GameResult {
        val ballCount: Int = this._ballCheck(player)
        val strikeCount: Int = this._strikeCheck(player)
        return GameResult(ballCount, strikeCount)
    }

    /** 현재 답과 사용자의 입력간의 ball의 개수를 알려주는 내부 함수 */
    fun _ballCheck(player: BaseballPlayer): Int {
        var ballCount: Int = 0

        // 정답의 i번째 값과 같은 값이 있지만 위치가 다른 경우를 확인
        for (i in (0..2)) {
            // 같은 위치에서 값이 같은 경우는 Strike이므로 이는 제외
            if (answer[i] == player.inputString[i]) continue

            // player의 입력에 answer[i]가 있다면 -> ball인 경우이므로 갯수 증가
            if (player.inputString.contains(answer[i])) {
                ++ballCount
            }
        }
        return ballCount
    }

    /** 현재 답과 사용자의 입력간의 strike의 개수를 알려주는 내부 함수 */
    fun _strikeCheck(player: BaseballPlayer): Int {
        var strikeCount: Int = 0

        // 정답과 palyer의 입력의 i번째 값들이 같은지 확인
        for (i in (0..2)) {
            // 각각의 i번째 값이 다른 경우는 strike에 해당하지 않으므로 제외
            if (this.answer[i] != player.inputString[i]) continue

            strikeCount += 1
        }
        return strikeCount
    }
}
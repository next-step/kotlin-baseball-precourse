class GameResult(var ballCount: Int, var strikeCount: Int) {
    // 현재 상태가 게임을 종료할 상태인지 확인하는 변수
    val isGameEnd: Boolean
        get() = (strikeCount == 3)

    /** 현재 게임 결과의 상태를 출력하는 함수 */
    fun printGameResult() {
        // ball이 있는 경우, ball의 수를 출력
        if (ballCount > 0) {
            print("${ballCount}볼 ")
        }

        // strike가 있는 경우, strike의 수를 출력
        if (strikeCount > 0) {
            print("${strikeCount}스트라이크 ")
        }

        // ball과 strike가 없는 경우에는 nothing을 출력
        if (ballCount == 0 && strikeCount == 0) {
            print("낫싱")
        }

        println("")
    }
}
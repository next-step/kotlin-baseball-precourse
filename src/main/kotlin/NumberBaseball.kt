/** 사용자가 game의 값을 맞출 때까지, 입력과 비교를 반복하는 시뮬레이션 함수 */
fun judgeFromUserInput(game: BaseballGame, player: BaseballPlayer) {
    while (true) {
        // 사용자로부터 입력을 받음
        print("숫자를 입력해주세요: ")
        val userInputText: String = readLine()!!

        // 입력받은 값을 player의 값으로 지정 -> 정당하지 않으면 오류 발생!
        player.inputString = userInputText

        // 결과를 판정하고 출력하기
        val result: GameResult = game.judgeGameResult(player)
        result.printGameResult()

        // 만약 종료 조건이라면 break하여 해당 함수 종료
        if (result.isGameEnd) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료!")
            break
        }
    }
}

fun main() {
    while (true) {
        println("===[숫자야구 게임]==========")

        // 게임 객체 생성 -> 생성과 동시에 정답이 정해짐
        var game: BaseballGame = BaseballGame()

        // 플레이어 객체 생성
        var player: BaseballPlayer = BaseballPlayer()

        // 사용자가 맞힐때 까지 계속해서 입력을 시도
        judgeFromUserInput(game, player)

        break   // 임시
    }
}
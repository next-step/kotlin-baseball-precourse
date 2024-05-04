fun main() {
    while (true) {
        println("===[숫자야구 게임]==========")

        // 게임 객체 생성 -> 생성과 동시에 정답이 정해짐
        var game: BaseballGame = BaseballGame()

        // 플레이어 객체 생성
        var player: BaseballPlayer = BaseballPlayer()

        // 사용자가 맞힐때 까지 계속해서 입력을 시도
        judgeFromUserInput(game, player)

        // 해당 프로그램을 재시작할지, 종료할지 결정
        if (wantExit()) break
    }
}

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

/** 사용자가 게임을 끝내고 싶은지 확인하는 함수
 *  @return 사용자가 그만하기를 원한다면 true, 계속하기를 원한다면 false 반환 */
fun wantExit(): Boolean {
    print("> 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")

    // 사용자로부터 입력을 받음
    val userInput: String = readLine()!!
    return when (userInput) {
        "1" -> false    // "1"을 입력한 경우, false 반환
        "2" -> true     // "2"를 입력한 경우, true 반환
        else -> wantExit()    // 그 외의 값을 입력한 경우, 재귀적으로 다시 반복
    }
}
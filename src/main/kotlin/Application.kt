fun main() {
    runSystem()
}

// 상대방 기능
fun createAnswer(): List<Int> {
    val range = (1..9)
    val numbers = mutableSetOf<Int>()
    while (numbers.size < 3) {
        numbers.add(range.random())
    }
    val answer: List<Int> = numbers.toList()
    return answer
}

// 시스템 기능
class GameInfo(mAnswer: List<Int>) {
    var ball: Int = 0
    var strike: Int = 0
    var answer: List<Int> = mAnswer

    fun clearScore() {
        ball = 0
        strike = 0
    }
}

fun runSystem() {
    do {
        startGame()
    } while (restartGame())
    println("애플리케이션을 종료합니다.")
}

fun startGame() {
    val gameInfo = GameInfo(createAnswer())
    do {
        print("숫자를 입력해 주세요 : ")
        var predict: List<Int> = getValidPredict()
        compareNumber(predict, gameInfo)
        printScore(gameInfo)
    } while (!checkEnd(gameInfo))
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun compareNumber(predict: List<Int>, gameInfo: GameInfo) {
    gameInfo.clearScore()
    predict.forEachIndexed { index: Int, num: Int ->
        val answerIdx: Int = gameInfo.answer.indexOf(num)
        if (answerIdx != -1 && answerIdx == index) {
            gameInfo.strike++
        } else if (answerIdx != -1) {
            gameInfo.ball++
        }
    }
}

fun printScore(gameInfo: GameInfo) {
    if (gameInfo.ball != 0)
        print("${gameInfo.ball}볼 ")
    if (gameInfo.strike != 0)
        print("${gameInfo.strike}스트라이크")
    if (gameInfo.ball == 0 && gameInfo.strike == 0)
        print("낫싱")
    println()
}

fun checkEnd(gameInfo: GameInfo): Boolean {
    return gameInfo.strike == 3
}

fun restartGame(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var restart: Boolean = false
    var opt: Int = 0
    try {
        opt = readln().toInt()
    }
    catch (exception: Exception) {
        throw IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.")
    }

    if (opt == 1) {
        restart = true
    } else if (opt == 2) {
        restart = false
    } else {
        println("1 또는 2를 입력하세요.")
        restart = restartGame()
    }
    return restart
}

fun getInput(): Int {
    var userInput: Int = 0
    try {
        userInput = readln().toInt()
    }
    catch (exception: Exception) {
        throw IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.")
    }
    return userInput
}

fun getValidPredict(): List<Int> {
    var temp: Int = 0
    while (true) {
        temp = getInput()
        if (temp in 111..999)
            break
        println("111에서 999사이의 3자리 수를 입력하세요.")
    }
    val num100: Int = temp / 100
    temp %= 100
    val num010: Int = temp / 10
    temp %= 10
    val num001: Int = temp
    return listOf(num100, num010, num001)
}
import kotlin.random.Random

fun main() {
    val secretNumber = generateSecretNumber()

    while (true) {
        playGame(secretNumber)
        if (!playAgain()) break
    }
}

fun generateSecretNumber(): IntArray {
    val secret = mutableListOf<Int>()
    while (secret.size < 3) {
        secret.add(Random.nextInt(1, 10))
    }
    return secret.toIntArray()
}

fun playGame(secretNumber: IntArray) {
    println("세 개의 숫자를 입력하세요(123처럼 빈칸 없이): ")
    val input = readLine()
    val guess = input?.let {
        if (it.length != 3) throw IllegalArgumentException("올바른 입력값이 아닙니다!")
        it.map { char -> char.toString().toInt() }.toIntArray()
    } ?: throw IllegalArgumentException("올바른 입력값이 아닙니다!")

    val (strike, ball) = checkGuess(guess, secretNumber)

    if (strike == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        playAgain()
    } else {
        if (strike > 0) println("$strike 스트라이크")
        if (ball > 0) println("$ball 볼")
        if (strike == 0 && ball == 0) println("낫싱")
    }
}

fun checkGuess(guess: IntArray, secretNumber: IntArray): Pair<Int, Int> {
    var strike = 0
    var ball = 0
    for (i in guess.indices) {
        if (guess[i] == secretNumber[i]) {
            strike++
        } else if (guess.contains(secretNumber[i])) {
            ball++
        }
    }
    return Pair(strike, ball)
}

fun playAgain(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val choice = readLine()
    return choice == "1"
}
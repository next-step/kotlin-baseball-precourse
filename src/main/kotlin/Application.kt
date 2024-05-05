fun selectRandomnumber(): List<String> {
    val randomNumbersInt = (1..9).shuffled().take(3)
    val randomNumbersStr = randomNumbersInt.map { it.toString() }
    return randomNumbersStr
}
fun inputNumber(): String {
    println("숫자를 입력해 주세요 : ")
    val playerNumberStr: String? = readLine()
    val inputPlayerNumberInt: Int = playerNumberStr!!.toInt()
    when (inputPlayerNumberInt) {
        in 111..999 -> {}
        else -> throw IllegalArgumentException("IllegalArgumentException")
    }
    val inputPlayerNumberStr = inputPlayerNumberInt.toString()
    return inputPlayerNumberStr
}
fun checkInputNumber(): String {
    val checkPlayerNumber = try {
        inputNumber()
    } catch (exception: IllegalArgumentException) {
        println("IllegalArgumentException")
        System.exit(1)
    }
    val playerNumber = checkPlayerNumber.toString()
    return playerNumber
}

fun restartCheck(): Int {
    val restartCheck = readLine()
    val restartInt = restartCheck!!.toInt()
    if (restartInt != 1 && restartInt != 2) throw IllegalArgumentException("IllegalArgumentException")
    return restartInt
}

fun gameStart() {
    val gameRadnomNumber = selectRandomnumber()

    while (true) {
        var strike: Int = 0
        var ball: Int = 0
        val playingNumber = checkInputNumber()
        if (playingNumber[0].toString() == gameRadnomNumber[0]) strike += 1
        else if (playingNumber[0].toString() == gameRadnomNumber[1] || playingNumber[0].toString() == gameRadnomNumber[2]) ball += 1
        if (playingNumber[1].toString() == gameRadnomNumber[1]) strike += 1
        else if (playingNumber[1].toString() == gameRadnomNumber[0] || playingNumber[1].toString() == gameRadnomNumber[2]) ball += 1
        if (playingNumber[2].toString() == gameRadnomNumber[2]) strike += 1
        else if (playingNumber[2].toString() == gameRadnomNumber[1] || playingNumber[2].toString() == gameRadnomNumber[0]) ball += 1

        if (strike == 0 && ball == 0) println("낫싱")
        else if (strike == 0) println("" + ball + "볼")
        else if (ball == 0) println("" + strike + "스트라이크")
        else println("" + ball + "볼 " + strike + "스트라이크")
        if (strike == 3) println("3개의 숫자를 모주 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        if (strike == 3) break
    }
    val restart = try {
        restartCheck()
    } catch (exception: IllegalArgumentException) {
        println("IllegalArgumentException")
        System.exit(1)
    }
    if (restart == 2) return
    else if (restart == 1) gameStart()
}

fun main() {
    gameStart()
}a
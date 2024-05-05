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
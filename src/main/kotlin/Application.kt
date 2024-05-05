fun selectRandomnumber(): List<String> {
    val randomNumbersInt = (1..9).shuffled().take(3)
    val randomNumbersStr = randomNumbersInt.map { it.toString() }
    return randomNumbersStr
}


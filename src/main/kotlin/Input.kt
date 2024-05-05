fun Input(): List<Int> {
    while (true) {
        println("3개의 숫자를 입력해주세요 : ")
        val input = readLine() ?: throw IllegalArgumentException("입력이 잘못되었습니다.")
        val userInput = input.map { it.toString().toIntOrNull() ?: throw IllegalArgumentException("입력이 잘못되었습니다.") }
        if (userInput.size != 3 || userInput.toSet().size != 3) {
            println("잘못된 입력입니다. 3개의 숫자를 1부터 9까지 중복 없이 입력해주세요.")
            throw IllegalArgumentException("입력이 잘못되었습니다.")
        } else {
            return userInput
        }
    }
}

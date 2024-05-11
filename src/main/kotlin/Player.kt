class Player {
    private fun getUserInput(): String {
        return readlnOrNull() ?: ""
    }

    fun getUserNumberInput(inputValidator: InputValidator): Array<Int> {
        print("숫자를 입력해 주세요 : ")
        val userInput: String = getUserInput()
        inputValidator.validateThreeDigitInput(userInput)

        return getArrayInput(userInput)
    }

    private fun getArrayInput(userInput: String): Array<Int> {
        val result: Array<Int> = Array(3) { 0 }
        result[0] = userInput[0].digitToInt()
        result[1] = userInput[1].digitToInt()
        result[2] = userInput[2].digitToInt()

        return result
    }

    fun getUserGameStatusInput(inputValidator: InputValidator): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val userInput: String = getUserInput()
        inputValidator.validateOneDigitInput(userInput)

        return userInput.toInt()
    }
}
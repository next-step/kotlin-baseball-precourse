class InputValidator {
    fun validateThreeDigitInput(userInput: String) {
        assertIntType(userInput)
        assertThreeDigit(userInput)
        assertDuplication(userInput)
    }

    fun validateOneDigitInput(userInput: String) {
        assertIntType(userInput)
        assertOneOrTwo(userInput)
    }

    private fun assertOneOrTwo(userInput: String) {
        val num = userInput.toInt()
        if (num == 1 || num == 2) {
            return
        }
        throw IllegalArgumentException ("입력값이 1 또는 2가 아닙니다.")
    }

    private fun assertIntType(userInput: String) {
        try {
            userInput.toInt()
            return
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException ("입력값이 정수가 아닙니다.")
        }
    }

    private fun assertThreeDigit(userInput: String) {
        if (userInput.length == 3) {
            return
        }
        throw IllegalArgumentException ("입력값이 세 자리수가 아닙니다.")
    }

    private fun assertDuplication(userInput: String){
        if (userInput[0] == userInput[1]) {
            throw IllegalArgumentException ("입력값에 중복이 존재합니다.")
        }
        if (userInput[1] == userInput[2]) {
            throw IllegalArgumentException ("입력값에 중복이 존재합니다.")
        }
        if (userInput[2] == userInput[0]) {
            throw IllegalArgumentException ("입력값에 중복이 존재합니다.")
        }
        return
    }
}
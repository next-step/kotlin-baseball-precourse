package utils

object ExceptionHandler {
    fun validateLengthOrException(answer: String, expectedLength: Int) {
        if (answer.length != expectedLength) throw IllegalArgumentException("입력값의 길이가 올바르지 않습니다.")
    }

    fun <E> validateListLengthOrException(list: List<E>, expectedLength: Int) {
        if (list.size != expectedLength) throw IllegalArgumentException("입력값의 길이가 올바르지 않습니다.")
    }

    fun validateDigitOrException(ch: Char): Int {
        val digit = ch.digitToIntOrNull() ?: throw IllegalArgumentException("입력값이 숫자가 아닙니다.")
        validateRangeOrException(digit)

        return digit
    }

    fun validateRangeOrException(digit: Int) {
        if (digit !in 1..9) throw IllegalArgumentException("입력값이 올바른 범위가 아닙니다.")
    }

    fun validateDuplicatedOrException(numbers: List<Int>) {
        val notDuplicatedNumbers = numbers.toSet()
        if (notDuplicatedNumbers.size != 3) throw IllegalArgumentException("중복된 숫자가 존재합니다.")
    }

    fun validateRestartCode(code: String) {
        validateLengthOrException(code, 1)
        validateRestartCodeCategory(code)
    }

    fun validateRestartCodeCategory(code: String) {
        if (code != "1" && code != "2") throw IllegalArgumentException("잘못된 입력 형식입니다.")
    }
}

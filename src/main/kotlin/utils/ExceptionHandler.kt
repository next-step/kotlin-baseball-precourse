package utils

import utils.Constraints.DIGIT_LENGTH

object ExceptionHandler {
    fun validateLengthOrException(answer: String, expectedLength: Int) {
        if (answer.length != expectedLength) throw IllegalArgumentException(Constraints.LENGTH_MISMATCH_EXCEPTION)
    }

    fun <E> validateListLengthOrException(list: List<E>, expectedLength: Int) {
        if (list.size != expectedLength) throw IllegalArgumentException(Constraints.LENGTH_MISMATCH_EXCEPTION)
    }

    fun validateDigitOrException(ch: Char): Int {
        val digit = ch.digitToIntOrNull() ?: throw IllegalArgumentException(Constraints.NON_DIGIT_EXCEPTION)
        validateRangeOrException(digit)

        return digit
    }

    fun validateRangeOrException(digit: Int) {
        if (digit !in Constraints.MIN_DIGIT..Constraints.MAX_DIGIT) throw IllegalArgumentException(Constraints.OUT_OF_RANGE_EXCEPTION)
    }

    fun validateDuplicatedOrException(numbers: List<Int>) {
        val notDuplicatedNumbers = numbers.toSet()
        if (notDuplicatedNumbers.size != DIGIT_LENGTH) throw IllegalArgumentException(Constraints.DUPLICATED_DIGIT_EXCEPTION)
    }

    fun validateRestartCode(code: String) {
        validateLengthOrException(code, Constraints.RESTART_LENGTH)
        validateRestartCodeCategory(code)
    }

    fun validateRestartCodeCategory(code: String) {
        if (code != Constraints.YES_RESTART && code != Constraints.NO_RESTART) throw IllegalArgumentException(Constraints.WRONG_FORMAT_EXCEPTION)
    }
}
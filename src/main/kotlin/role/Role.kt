package role

import utils.ExceptionHandler

sealed class Role(
    protected val numbers: List<Int>
) {

    init {
        validate()
    }

    private fun validate() {
        ExceptionHandler.validateListLengthOrException(numbers, 3)
        ExceptionHandler.validateDuplicatedOrException(numbers)
    }

    fun find(index: Int): Int = numbers[index]
    fun contains(number: Int): Boolean = numbers.contains(number)
    fun isEquals(index: Int, number: Int): Boolean = (find(index) == number)
}

class Player(numbers: List<Int>) : Role(numbers)
class Computer(numbers: List<Int>) : Role(numbers)

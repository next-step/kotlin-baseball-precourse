import kotlin.IllegalArgumentException
import kotlin.NumberFormatException

class UserInterface() {
    fun printResult(strikeAndBallCountList: List<Int>) {
        println(replaceCountListWithString(strikeAndBallCountList))
    }

    fun replaceCountListWithString(strikeAndBallCountList: List<Int>): String {
        val strikeIndex = 0
        val ballIndex = 1
        return if ((strikeAndBallCountList[strikeIndex] == 0) and (strikeAndBallCountList[ballIndex] == 0)) {
            "낫싱"
        } else if (strikeAndBallCountList[strikeIndex] == 0) {
            "${strikeAndBallCountList[ballIndex]}볼"
        } else if (strikeAndBallCountList[ballIndex] == 0) {
            "${strikeAndBallCountList[strikeIndex]}스트라이크"
        } else "${strikeAndBallCountList[strikeIndex]}스트라이크 ${strikeAndBallCountList[ballIndex]}볼"
    }

    fun inputThreeNumber(): List<Int> {
        print("숫자를 입력해 주세요 : ")
        val number = readln()
        return changeNumber(number)
    }

    fun changeNumber(stringNumber: String): List<Int> {
        val intNumber = inputStrToIntNumber(stringNumber)
        val listNumber = listOf<Int>()

        checkHundredNumber(intNumber)
        val newListNumber = listNumber + intNumber / 100 + (intNumber % 100) / 10 + (intNumber % 10)
        checkContainZero(newListNumber)
        checkDuplicateNum(newListNumber)
        return newListNumber
    }

    fun inputStrToIntNumber(stringNumber: String): Int {
        try {
            return stringNumber.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자가 아닌 값을 입력 했습니다. : $stringNumber")
        }
    }

    fun checkHundredNumber(intNumber: Int) {
        if (isNotHundredNumber(intNumber)) throw IllegalArgumentException("허용된 범위의 수가 아닙니다.: ${intNumber}")
    }

    fun isNotHundredNumber(intNumber: Int): Boolean {
        return !((intNumber >= 123) and (intNumber <= 987))
    }

    fun checkContainZero(listNumber: List<Int>) {
        if (isContainZero(listNumber)) throw IllegalArgumentException("0은 포함할 수 없습니다 : ${listNumber}")
    }

    fun isContainZero(listNumber: List<Int>): Boolean {
        return listNumber.contains(0)
    }

    fun checkDuplicateNum(listNumber: List<Int>) {
        if (isDuplicateNum(listNumber)) throw IllegalArgumentException("중복 되지 않은 수여야 합니다 : ${listNumber}")
    }

    fun isDuplicateNum(listNumber: List<Int>): Boolean {
        val setNumber = listNumber.toSet()
        return setNumber.size < 3
    }

    fun inputGameRestart(): Int {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val strGameRestart = readln()
        return checkGameRestartException(strGameRestart)
    }

    fun checkGameRestartException(strGameRestart: String): Int {
        val intGameRestart = inputStrToIntNumber(strGameRestart)
        if (!((intGameRestart == 1) or (intGameRestart == 2))) throw IllegalArgumentException("옳은 입력이 아닙니다.: ${intGameRestart}")
        return intGameRestart
    }
}
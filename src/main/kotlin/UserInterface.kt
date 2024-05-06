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
}
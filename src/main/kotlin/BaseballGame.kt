import kotlin.random.Random

// HOW_MANY_BALLS
// 유추해야 할 수의 자리수
// 과제에서는 3자리로 한정되어 있지만 해당 값을 바꾸면 자리수도 바꿔진다
class BaseballGame(private val HOW_MANY_BALLS : Int) {
    private val answer: List<Int> = makeAnswer()

    // 랜덤한 정답 생성 함수
    private fun makeAnswer(): List<Int> {
        var _answer = mutableListOf(3)

        // 1~9의 랜덤 수를 추출
        // 이미 리스트에 담겨있으면 다시 시행, 없으면 리스트에 추가
        // 리스트 길이가 3이 될때까지 반복한다
        while (_answer.size != HOW_MANY_BALLS) {
            val num = Random.nextInt(1, 9)

            if (!_answer.contains(num)) {
                _answer.add(num)
            }
        }
        return _answer
    }

    fun getAnswer(): String {
        return answer.joinToString("")
    }

}

fun main() {
    var baseballGame = BaseballGame(3)

    println(baseballGame.getAnswer())

}
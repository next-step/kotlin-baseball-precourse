import kotlin.random.Random

// HOW_MANY_BALLS
// 유추해야 할 수의 자리수
// 과제에서는 3자리로 한정되어 있지만 해당 값을 바꾸면 자리수도 바꿔진다
class BaseballGame(private val HOW_MANY_BALLS : Int) {
    private val answer: List<Int> = makeAnswer()
    private var _strikeCount : Int = 0
    private var _ballCount : Int = 0

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

    // 볼, 스트라이크 카운트 초기화 함수
    private fun initCount() {
        _ballCount = 0
        _strikeCount = 0
    }

    // 계산한 볼, 스트라이크 카운트 출력 함수
    // 볼, 스트라이크의 합이 0일 경우 낫싱으로 판단
    private fun printCount(){
        if(_ballCount + _strikeCount == 0){
            println("낫싱")
            return
        }

        if (_ballCount > 0){
            print("${_ballCount}볼 ")
        }
        if (_strikeCount > 0){
            println("${_strikeCount}스트라이크")
        } else {
            println("")
        }
    }

    // 사용자가 게임을 하기위해 호출하는 추측 메서드
    fun guess(guessNum: String) {

        initCount()

        // 추측한 수의 각 자리수 및 인덱스 추출
        for ((idx, guessDigit) in guessNum.withIndex()) {
            // 정답의 인덱스와 자리수의 인덱스가 같은 경우
            // -> 스트라이크
            if (answer[idx] == guessDigit.digitToInt()) {
                _strikeCount++
            }
            // 인덱스가 같진 않지만 해당 수가 정답에 존재하는 경우
            // -> 볼
            else if (answer.contains(guessDigit.digitToInt())) {
                _ballCount++
            }
        }

        printCount()
    }



}

fun main() {
    var baseballGame = BaseballGame(3)

    println(baseballGame.getAnswer())

    baseballGame.guess("123")
    baseballGame.guess("456")
    baseballGame.guess("789")
    baseballGame.guess("234")







}
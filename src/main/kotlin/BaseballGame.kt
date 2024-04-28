import kotlin.random.Random

// HOW_MANY_BALLS
// 유추해야 할 수의 자리수
// 과제에서는 3자리로 한정되어 있지만 해당 값을 바꾸면 자리수도 바꿔진다
class BaseballGame(private val HOW_MANY_BALLS: Int) {
    var answer: List<Int>
    var _strikeCount: Int = 0
    var _ballCount: Int = 0

    // 종료 플래그
    // 메인에서 호출 시 terminateFlag가 true가 될 때까지 doGame을 호출한다
    var terminateFlag: Boolean = false

    init {
        answer = makeAnswer()
    }

    // 랜덤한 정답 생성 함수
    fun makeAnswer(): List<Int> {
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

    // 깔끔한 비교를 위해 정규 표현식으로 유효성 검증
    // (?! .. ) 는 negative lookahead. 즉, 다음에 나올 패턴에 부합하지 않는 패턴만 매치함
    // *(.).*\\1 는 문자열에 존재하는 모든 char에 대해 중복이 존재하는지 확인
    //   보충 : *(.).* 부분을 통해 한가지의 char를 그룹 캡처. 이는 존재하는 모든 char에 대해 반복한다
    //         그 후 캡처한 그룹 \\1 을 통해 본인을 제외한 char중 같은 것이 있는지 확인을 진행한다
    //         ?!에 의해 존재하는 경우 매칭되지 않는다
    // [1-9]{3} 은 1~9의 숫자로 3자리 수여야 함을 뜻함
    fun isValidInput(num: String): Boolean {
        val regex = Regex("^(?!.*(.).*\\1)[1-9]{${HOW_MANY_BALLS}}$")
        return regex.matches(num)
    }

    // 볼, 스트라이크 카운트 초기화 함수
    private fun initCount() {
        _ballCount = 0
        _strikeCount = 0
    }

    // 계산한 볼, 스트라이크 카운트 출력 함수
    // 볼, 스트라이크의 합이 0일 경우 낫싱으로 판단
    private fun printGuessResult() {
        if (_ballCount + _strikeCount == 0) {
            println("낫싱")
            return
        }

        if (_ballCount > 0) {
            print("${_ballCount}볼 ")
        }
        if (_strikeCount > 0) {
            println("${_strikeCount}스트라이크")
        } else {
            println("")
        }
    }

    // 유추한 수의 스트라이크, 볼을 판단하는 메서드
    // 정규표현식 이용을 위해 String으로 파라미터를 받는다
    fun guess(guessNum: String) {

        initCount()
        // 유효하지 않은 수일 경우 IllegalArgumentException 발생
        // 이 결과는 main 함수의 try catch 문에서 이어진다
        if (!isValidInput(guessNum)) {
            throw IllegalArgumentException("올바르지 않은 형식입니다. \n서로 다른 1에서 9까지의 수로 이루어진 3자리 수를 입력하세요.\nex) 123, 456")
        }

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
    }

    // 사용자가 게임을 하기위해 호출하는 메서드
    // 숫자를 입력받고 guess()에 넘긴다.
    // IllegalArgumentException 발생시 메시지 출력 후 종료 플래그를 true로 바꾼다
    // 각 유추시 마다 printGuessResult()를 호출하여 결과를 출력하고
    // 모든 숫자를 맞췄을 시 restart()를 호출해 계속 진행할 지를 물어본다
    fun doGame() {
        print("숫자를 입력해 주세요 : ")
        val guessNum = readLine() ?: ""

        try {
            guess(guessNum)
            printGuessResult()
            if (_strikeCount == HOW_MANY_BALLS) {
                println("${HOW_MANY_BALLS}개의 숫자를 모두 맞히셨습니다! 게임 종료")
                restart()
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            terminateFlag = true
        }

    }

    // 게임이 종료 됐을 시 실행되는 메서드
    // 값을 입력 받고 1이면 정답을 초기화 한다
    // 1이 아닌 다른 수일 경우 종료 플래그를 true로 바꾼다
    fun restart() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        if (readLine() ?: "" == "1") {
            answer = makeAnswer()
        } else {
            terminateFlag = true
        }
    }


}

fun main() {
    var baseballGame = BaseballGame(3)

    while (!baseballGame.terminateFlag) {
        baseballGame.doGame()
    }
    println("프로그램을 종료합니다.")
}
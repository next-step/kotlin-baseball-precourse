import kotlin.random.Random

fun main() {
    // 게임의 메인 루프 처리
    do {
        // 정답(3개의 난수) 생성
        val secretNumber = generateSecretNumber()
        try{
            // 게임 시작
            playGame(secretNumber)
        }catch(e: IllegalArgumentException){
            // 잘못된 입력이 들어왔을 때 예외를 잡아서 메시지를 출력하고 게임 종료
            println(e.message)
            println("잘못된 입력으로 인해 게임을 종료합니다.")
            break // 프로그램 종료
        }
        // 게임을 재시작할 지 묻는 로직을 처리하는 함수 호출
    } while (handleGameRestart())
    println("게임 종료.") // 사용자가 게임 종료를 원할 때 출력
}

// 정답(3개의 난수)을 생성하는 함수
fun generateSecretNumber(): List<Int> {
    // 중복되지 않는 숫자 세 개를 저장하기 위한 MutableList
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
        // 1부터 9까지 무작위 번호 생성
        val randomNumber = Random.nextInt(1, 10)
        // 중복된 번호가 아니라면 리스트에 추가
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }
    return numbers // 생성된 정답 반환
}

// 실제 게임 플레이를 처리하는 함수
fun playGame(secretNumber: List<Int>) {
    while (true) {
        // 사용자의 추측 값을 받고 정답과 비교하여 맞췄는지 확인
        if (makeGuess(secretNumber)) break // 성공 시 루프 종료
    }
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

// 사용자로부터 추측 값을 입력받고 결과를 확인하는 함수
fun makeGuess(secretNumber: List<Int>): Boolean {
    print("숫자를 입력해 주세요: ")
    val guess = readLine()!!.trim()
    if(guess.length != secretNumber.size || !guess.all { it.isDigit() }) {
        // 입력 값의 유효성을 체크하고 유효하지 않을 경우 예외 발생
        throw IllegalArgumentException("유효하지 않은 숫자 입력입니다. 3자리 숫자를 입력해 주세요.")
    }
    val result = checkGuess(guess, secretNumber)
    displayResult(result) // 추측 결과 출력
    return result.first == 3 // 모든 숫자가 정확하게 맞으면 true 반환
}

// 사용자의 추측을 정답과 비교하여 결과를 반환하는 함수
fun checkGuess(guess: String, secretNumber: List<Int>): Pair<Int, Int> {
    var strikes = 0 // 위치와 숫자 모두 맞는 경우
    var balls = 0 // 숫자는 맞지만 위치가 틀린 경우
    for (index in guess.indices) {
        val num = guess[index].toString().toInt()
        if (num == secretNumber[index]) {
            strikes++ // 숫자와 위치 모두 일치
        } else if (num in secretNumber) {
            balls++ // 숫자는 있지만 위치 불일치
        }
    }
    return Pair(strikes, balls) // 결과 반환
}

// 추측 결과를 사용자에게 알려주는 함수
fun displayResult(result: Pair<Int, Int>) {
    when {
        result.first == 0 && result.second == 0 -> println("낫싱")
        result.first > 0 && result.second > 0 -> println("${result.second}볼 ${result.first}스트라이크")
        result.first > 0 -> println("${result.first}스트라이크")
        result.second > 0 -> println("${result.second}볼")
    }
}

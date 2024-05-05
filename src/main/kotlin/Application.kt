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

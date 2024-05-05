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


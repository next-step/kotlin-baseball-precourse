import engine.BallCount
import engine.io.Output
import engine.io.Input
import java.util.Scanner

class Console : Input, Output{
    private val scanner = Scanner(System.`in`)

    override fun input(message: String): String {
        print(message)
        return scanner.nextLine()
    }

    override fun displayBallCount(ballCount: BallCount) {
        with(ballCount) {
            when {
                strike > 0 && ball > 0 -> println("${ball}볼 ${strike}스트라이크")
                strike > 0 -> println("${strike}스트라이크")
                ball > 0 -> println("${ball}볼")
                else -> println("낫싱")
            }
        }
    }

    override fun displayInputError(errorMessage: String?) {
        println(errorMessage ?: "입력값에 오류가 있습니다. 애플리케이션을 종료합니다.")
    }

    override fun displayCorrectMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

}
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
        println("${ballCount.ball}볼 ${ballCount.strike}스트라이크")
    }

    override fun displayInputError() {
        println("입력이 잘못되었습니다. 앱 종료")
    }

    override fun displayCorrectMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

}
import java.lang.IllegalArgumentException
import kotlin.random.Random

/**
 * 숫자야구 프로그램.
 * 게임을 운영하는 클래스
 */
class Game() {
    var win:Boolean = false
    var numbers:IntArray = intArrayOf()
    var answer:Int = 0

    /**
     * 게임의 시작을 관리하는 메소드
     * @return 재시작 여부 변수 answer: 1이면 재시작, 2면 종료
     */
    fun run():Int {
        generate()
//        println(numbers.joinToString(separator = ", ")) // 확인용 출력
        while (!win) {
            input()
            check()
        }
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        answer = examine()
        if (answer == 1 || answer == 2) return answer
        else error("잘못된 입력: run: 1이나 2가 아님")
    }

    /**
     * 게임에 사용할 숫자배열을 생성하는 메소드
     */
    fun generate() {
        val set = LinkedHashSet<Int>()
        while (set.size < 3) {
            set.add(Random.nextInt(1, 10))
        }
        numbers = set.toIntArray()
    }

    /**
     * 사용자의 입력을 받는 메소드
     * 두 자리의 숫자일 경우 에러 발생
     */
    fun input() {
        print("숫자를 입력해주세요 : ")
        answer = examine()
        if (answer > 999 || answer < 100)
            error("잘못된 입력: input: 세 자리의 숫자가 아님")
    }

    /**
     * 사용자의 입력의 유효성을 검사하는 메소드
     * 입력이 null/숫자 이외/0 일 경우 에러 발생
     * @return 유효한 사용자의 입력
     */
    fun examine(): Int {
        var line:String? = readLine()
        if (line == null)
            error("잘못된 입력: examine: null")
        else if (line.toIntOrNull() == null)
            error("잘못된 입력: examine: 숫자 이외의 입력")
        else if (line?.contains("0") == true)
            error("잘못된 입력: examine: 0")
        return line.toInt()
    }

    /**
     * 사용자의 입력과 정답을 비교하는 메소드
     */
    fun check() {
        var ball:Int = 0
        var strike:Int = 0
        var divide:Int = 100
        var num:Int = 0
        for (i in 0..2) {
            num = answer/divide
            if (num == numbers[i]) strike++
            else if (num in numbers) ball++
            answer %= divide
            divide /= 10
        }

        if (ball+strike == 0) print("낫싱")
        if (ball != 0) print("${ball}볼 ")
        if (strike != 0) print("${strike}스트라이크")
        println()

        if (strike == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            win = true
        }
    }
}


/**
 * 게임을 작동시키는 메인 메소드
 * Game 객체 실행 중 에러 발생 캐치
 */
fun main() {
    var play:Int = 1
    while (play == 1) {
        val game = Game()
        try {
            play = game.run()
        } catch (e: Exception) {
            throw IllegalArgumentException("예외 발생: ${e.message}. 애플리케이션 종료")
        }
    }
    println("프로그램 종료")
}
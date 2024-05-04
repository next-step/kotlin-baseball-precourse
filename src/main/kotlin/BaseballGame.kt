import kotlin.random.Random
import java.io.BufferedReader
class BaseballGame {
     var targetNumber = mutableListOf<Int>()


    init {
        makeRandomNumber()
    }

    private fun getTargetNumber() : Unit {
        targetNumber.forEach(){
            print(it)
        }
    }

    fun playGame() {
        var gamingFlag = true
        while (gamingFlag == true) {
            val inputNumber: Int = fetchNumericInput()
            val result : String = calculate(inputNumber)
            println(result)
            if (result == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                gamingFlag = false
            }
        }
    }

    fun makeRandomNumber() : Unit {
        // 3글자 난수 생성
        var digits = mutableSetOf<Int>()
        while (digits.size < 3) {
            val randomDigit = Random.nextInt(1, 10)
            digits.add(randomDigit)
        }
        targetNumber = digits.toMutableList()
    }

    fun fetchNumericInput(): Int {
        var inputNumber = 0
        print("숫자를 입력해 주세요 : ")
        val inputString: String? = readLine()
        if(inputString == null || inputString.length != 3) throw IllegalArgumentException("잘못된 입력입니다.")
        try {
            inputNumber = inputString.toInt()
        } catch (e : IllegalArgumentException){
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
        return inputNumber
    }

    fun calculate(inputNumber : Int) : String {
        val inputDigits = inputNumber.toString().map { it.toString().toInt() }
        var strikes = 0
        var balls = 0

        inputDigits.forEachIndexed { index, digit ->
            if (digit == targetNumber[index]) {
                strikes++
            } else if (digit in targetNumber) {
                balls++
            }
        }
        return formatResult(balls, strikes)
    }

    private fun formatResult(balls: Int, strikes: Int) : String  {
        return when {
            strikes == 0 && balls == 0 -> "낫싱"
            strikes == 0 -> "${balls}볼"
            balls == 0 -> "${strikes}스트라이크"
            else -> "${balls}볼 ${strikes}스트라이크"
        }
    }





}
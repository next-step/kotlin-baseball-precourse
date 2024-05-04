import kotlin.random.Random
import java.io.BufferedReader
class BaseballGame {
     var targetNumber = mutableListOf<Int>()




    init {
        makeRandomNumber()
    }

    fun getTargetNumber() : Unit {
        targetNumber.forEach(){
            print(it)
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
}
import kotlin.random.Random

class Game {
    val threeNumber: MutableList<Int>
    var continueGame: Boolean

    init {
        threeNumber = generateRandomNumber()
        continueGame = true
    }

    fun gameStart() {
        while (continueGame) {
            print("숫자를 입력해 주세요 : ")
            val input = readlnOrNull()
            val result: String = checkNumber(threeNumber, inputNumber(input))
            println(result)
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    private fun generateRandomNumber(): MutableList<Int> {
        val numbers = mutableListOf<Int>()
        while (numbers.size < 3) {
            val randomNumber = Random.nextInt(1, 10)
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }
        return numbers
    }

    fun inputNumber(input: String?): MutableList<Int> {
        val playerNumbers = mutableListOf<Int>()

        //null 입력 했을 경우 예외처리
        input ?: throw IllegalArgumentException("null 값이 입력됐습니다.")

        //세 자리 수 입력을 하지 않았을 경우 예외처리 ex) 12
        if (input.length != 3) {
            throw IllegalArgumentException("3개의 숫자를 입력해야 합니다.")
        }

        for (num in input) {
            // 1부터 9까지의 숫자가 아닐 경우 예외처리 ex)12#
            if (num !in '1'..'9') {
                throw IllegalArgumentException("1부터 9까지의 숫자만 입력해야 합니다.")
            }
            val numInt = num.toString().toInt()
            //중복된 숫자를 입력 했을 때 예외처리 ex) 122
            if (playerNumbers.contains(numInt)) {
                throw IllegalArgumentException("중복된 숫자를 입력했습니다.")
            }
            playerNumbers.add(numInt)
        }
        return playerNumbers
    }

    fun checkNumber(
        resultNumbers: MutableList<Int>, playerNumbers: MutableList<Int>
    ): String {
        var strike = 0
        var ball = 0
        for ((index, value) in playerNumbers.withIndex()) {
            if (resultNumbers.contains(value) && resultNumbers[index] == value) {
                strike++
            } else if (resultNumbers.contains(value)) {
                ball++
            } else {
                continue
            }
        }
        return printHint(strike, ball)
    }

    fun printHint(strike: Int, ball: Int): String {
        if (strike > 0 && ball > 0) {
            return "${ball}볼 ${strike}스트라이크"
        } else if (strike > 0) {
            if (strike == 3) {
                continueGame = false
            }
            return "${strike}스트라이크"
        } else if (ball > 0) {
            return "${ball}볼"
        } else {
            return "낫싱"
        }
    }
}


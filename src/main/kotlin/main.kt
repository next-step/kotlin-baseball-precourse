class Com {

    var randomNumber: IntArray = IntArray(3)
    var strike: Int = 0
    var ball: Int = 0
    var game: Boolean = true


    fun makeNumber() {
        val usedNumbers = Array(10) { false }
        for (i in 0 until 3) {
            randomNumber[i] = (1..9).random()
            while (usedNumbers[randomNumber[i]]) {
                randomNumber[i] = (1..9).random()
            }
            usedNumbers[randomNumber[i]] = true
        }
        println("랜덤한 숫자: ${randomNumber.joinToString()}")
    }

    fun compare(userInput: IntArray) {
        strike = 0
        ball = 0
        for (i in 0..2) {
            if (randomNumber[i] == userInput[i]) {
                strike++
            }
            else if (userInput.contains(randomNumber[i])) {
                ball++
            }
        }

        if (strike == 0 && ball == 0) {
            println("낫싱")
        } else {
            println("${strike}스트라이크 ${ball}볼")
        }

        if (strike == 3) {
            game = false
            println("정답!")
        }

    }

}

class User {

    var inputNumber: Int = 0
    var inputArray: IntArray = IntArray(3,{0})

    fun input() {
        println("1~9 사이의 숫자 3개를 공백없이 입력하세요:")
        try {
            inputNumber = readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("올바른 숫자를 입력하세요.")
        }
        if (inputNumber !in 111..999) {
            throw IllegalArgumentException("1~9 사이의 숫자를 3개 입력하세요.")
        }
    }

//    fun print() {
//        println("입력한 숫자: $inputNumber")
//    }

    fun change() {
        inputArray[0]= inputNumber/100
        inputArray[1] = (inputNumber / 10) % 10
        inputArray[2] = inputNumber%10
        //println("변환된 숫자 배열: ${inputArray.joinToString()}")
    }
}


fun play () {
    val com = Com()
    com.makeNumber()
    val user = User()
    while (com.game) {
        user.input()
        user.change()
        com.compare(user.inputArray)
    }
    if (!com.game) {
        println("게임을 계속 할까요? y를 누르면 다시 시작")
        var a = readlnOrNull()
        if (a == "y"){
            play()
        }else {
            println("종료합니다.")
        }
    }
}

fun main() {
    play()
}
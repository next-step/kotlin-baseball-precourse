

class Com constructor(){

    var randomNumber: IntArray = IntArray(3)


    fun makeNumber() {
        for (i in 0..2) randomNumber[i] = (1..9).random()
        println("랜덤한 숫자: ${randomNumber.joinToString()}")
    }



}

class User constructor(){

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

    fun print() {
        println("입력한 숫자: $inputNumber")
    }

    fun change() {
        inputArray[0]= inputNumber/100
        inputArray[1] = (inputNumber / 10) % 10
        inputArray[2] = inputNumber%10
        println("변환된 숫자 배열: ${inputArray.joinToString()}")
    }
}

fun main() {
    val com = Com()
    com.makeNumber()
    val user = User()
    user.input()
    user.print()
    user.change()
}
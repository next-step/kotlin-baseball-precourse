import kotlin.random.Random

class Play {

    var randomNumber: IntArray = IntArray(3)

    fun makeNumber() {
        for (i in 0..2) randomNumber[i] = (1..9).random()
        println("랜덤한 숫자: ${randomNumber.joinToString()}")
    }
}

fun main() {
    val game = Play()
    game.makeNumber()
}

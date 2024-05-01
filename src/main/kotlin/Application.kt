import kotlin.random.Random

fun generateGoalNumber(): String {
    var number = mutableSetOf<Int>()

    while (number.size < 3){
        val randomNumber = Random.nextInt(1,10)
        number.add(randomNumber)
    }
    return number.joinToString("")
}

fun main() {}
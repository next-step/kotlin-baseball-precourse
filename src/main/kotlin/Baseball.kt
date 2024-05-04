import kotlin.random.Random

fun main() {
    val answerNumList = setRandomNumber()

}

fun setRandomNumber() : List<Int> {
    val randomNum = mutableListOf<Int>()
    while (randomNum.size < 3) {
        val num = Random.nextInt(1,9)
        if (!randomNum.contains(num))
            randomNum.add(num)
    }
    return randomNum
}
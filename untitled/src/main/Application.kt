import kotlin.random.Random

fun main() {
    val tmp = mutableListOf<Int>()
    while (tmp.size < 3) {
        tmp.add(Random.nextInt(9))
    }

    val answer = tmp.joinToString("").toInt()
    print(answer)
}
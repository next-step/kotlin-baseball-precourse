fun main() {

}

fun selectNum(): List<Int> {
    val numList = mutableListOf<Int>()
    var num: Int = 0
    val range = 1..9  // 1 <= n <= 15

    while (numList.size < 3) {
        num = range.random()
        if (!numList.contains(num)) {
            numList.add(num)
        }
    }
    return numList
}

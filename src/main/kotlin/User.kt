class User {
    private var _number: String = ""

    public fun setRandomNum(): Unit {
        val randomNum = mutableListOf<Int>()
        while (randomNum.size < 3) {
            val num = (1..9).random()
            if (randomNum.contains(num)) continue
            randomNum.add(num)
        }
        _number = randomNum.joinToString("")
    }

    public fun compareNum(enemyNum: String): Int {
        return 0
    }
}
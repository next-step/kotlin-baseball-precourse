class Computer constructor() {
    var correctNumberList:List<Int> = listOf<Int>()

    init {
        generateRandomNumber()
    }

    fun generateRandomNumber() {
        while (correctNumberList.size < 3) {
            val randomNumber: Int = (1..9).random()
            if (!(correctNumberList.contains(randomNumber))) {
                correctNumberList = correctNumberList + randomNumber
            }
        }
    }
}
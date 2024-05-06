class Computer constructor() {
    var correctNumberList: List<Int> = listOf<Int>()

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

    fun compareInputWithCorrectNumber(inputAnswer: List<Int>): List<Int> {
        var numberOfStrike: Int = 0
        var numberOfBall: Int = 0
        for (i in 0..2) {
            numberOfStrike += checkStrikes(i, inputAnswer[i], correctNumberList)
            numberOfBall += checkBalls(i, inputAnswer[i], correctNumberList)
        }
        return listOf(numberOfStrike, numberOfBall)
    }

    fun checkStrikes(index: Int, inputNumber: Int, targetList: List<Int>): Int {
        return if (targetList[index] == inputNumber) 1
        else 0
    }

    fun checkBalls(index: Int, inputNumber: Int, targetList: List<Int>): Int {
        return if ((checkStrikes(
                index, inputNumber, targetList
            ) == 0) and targetList.contains(inputNumber)
        ) 1
        else 0
    }
}
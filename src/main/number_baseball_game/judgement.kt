package com.example.number_baseball_game

class judgement {

    var strike: Int = 0
    var ball: Int = 0

    fun judge(inputNumber: Array<Int?>, answerNumber: Array<Int?>): Boolean {
        resetCounts()

        inputNumber.forEachIndexed { index, inputNum ->
            if (inputNum == answerNumber[index]) {
                strike++
            } else if (inputNum in answerNumber) {
                ball++
            }
        }

        return strike == 3
    }

    private fun resetCounts() {
        strike = 0
        ball = 0
    }
}
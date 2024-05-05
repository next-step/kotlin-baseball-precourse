package com.example.number_baseball_game

class userInput(val judgement: judgement) {

    val userNumber: Array<Int?> = arrayOfNulls<Int>(3)

    fun userInput(answer: Array<Int?>, judgement: judgement) {
        while (true) {
            try {
                print("숫자 세 개를 입력해주세요: ")
                val inputNumber: String = readLine() ?: throw IllegalArgumentException("입력이 없습니다.")

                if (inputNumber.length != 3 || !inputNumber.all { it.isDigit() }) {
                    throw IllegalArgumentException("다시 입력해주세요.")
                }

                userNumber[0] = inputNumber.substring(0, 1).toInt()
                userNumber[1] = inputNumber.substring(1, 2).toInt()
                userNumber[2] = inputNumber.substring(2, 3).toInt()

                if (judgement.judge(userNumber, answer)) {
                    println("정답입니다!")
                    break
                } else if (judgement.strike == 0 && judgement.ball == 0) {
                    println("낫싱")
                    false
                } else {
                    println("${judgement.strike} 스트라이크, ${judgement.ball} 볼")
                    false
                }

            } catch (e: IllegalArgumentException) {
                println(e.message) // 예외 메시지 출력
            }


        }
    }

}
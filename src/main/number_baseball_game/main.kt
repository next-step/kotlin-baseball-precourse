package com.example.number_baseball_game


fun main() {
    println("숫자야구 게임 시작")

    while(true) {
        val answer: random = random()
        answer.randomNumber()
//        println(answer.ranNumber.contentToString())

        var judge: judgement = judgement()
        val user = userInput(judge)
        user.userInput(answer.ranNumber, judge)
        judge.judge(user.userNumber, answer.ranNumber)

        val ExitOrContinue = ExitOrContinue()
        if (ExitOrContinue.askForNewGame()) continue
        else break
    }

}
package com.example.number_baseball_game

class ExitOrContinue {

    fun askForNewGame(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return when (readLine()) {
            "1" -> true
            else -> false
        }
    }
}
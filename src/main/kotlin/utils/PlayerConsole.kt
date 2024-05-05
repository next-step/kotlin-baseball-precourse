package utils

import role.Player
import utils.ExceptionHandler.validateDigitOrException
import utils.ExceptionHandler.validateRestartCode

object PlayerConsole {
    fun enterAnswer(): Player {
        print("숫자를 입력해주세요 : ")

        val answers = arrayListOf<Int>()
        val playerInput = readLine()

        playerInput?.forEach { ch ->
            val digit = validateDigitOrException(ch)
            answers.add(digit)
        }

        return Player(answers)
    }

    fun enterRestart(): String {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        val restartCode = readLine()
        validateRestartCode(restartCode.toString())

        return restartCode.toString()
    }
}

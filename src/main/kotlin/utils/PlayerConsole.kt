package utils

import role.Player
import utils.Constraints.ENTER_NUMBER_TEXT
import utils.Constraints.RESTART_ASKING_TEXT
import utils.ExceptionHandler.validateDigitOrException
import utils.ExceptionHandler.validateRestartCode

object PlayerConsole {
    fun enterAnswer(): Player {
        print(ENTER_NUMBER_TEXT)

        val answers = arrayListOf<Int>()
        val playerInput = readLine()

        playerInput?.forEach { ch ->
            val digit = validateDigitOrException(ch)
            answers.add(digit)
        }

        return Player(answers)
    }

    fun enterRestart(): String {
        println(RESTART_ASKING_TEXT)

        val restartCode = readLine()
        validateRestartCode(restartCode.toString())

        return restartCode.toString()
    }
}
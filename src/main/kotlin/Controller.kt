import User
import View
import java.lang.IllegalArgumentException

class Controller {
    private val _computer: User = User()
    private val _view: View = View()

    public fun run(): Unit {
        do {
            _game()
        } while (_inputNewGame() == 1)
    }

    private fun _game(): Unit {
        _computer.setRandomNum()
        do {
            val userInput: String = _inputUserNum()
            val state: Int = _computer.compareNum(userInput)
            _outputState(state)
        } while (state != 30)
    }

    private fun _inputNewGame(): Int {
        _view.outputln("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        val userInput: String = _view.input()
        if (userInput != "1" && userInput != "2")
            throw IllegalArgumentException("올바른 입력이 아닙니다.")
        return userInput.toInt()
    }

    private fun _inputUserNum(): String {
        _view.output("숫자를 입력해 주세요 : ");
        val userInput: String = _view.input()
        if (!"[1-9]{3}".toRegex().matches(userInput))
            throw IllegalArgumentException("올바른 입력이 아닙니다.")
        return userInput
    }

    private fun _outputState(state: Int): Unit {

    }
}
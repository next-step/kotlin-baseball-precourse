import User
import View

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
        return 0
    }

    private fun _inputUserNum(): String {
        return ""
    }

    private fun _outputState(state: Int): Unit {

    }
}
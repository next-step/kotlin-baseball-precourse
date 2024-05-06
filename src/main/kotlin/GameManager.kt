import kotlin.random.Random

class GameManager constructor(){
    var computerNumber: String = ""

    fun setComputerNumber(){
        val numbers = (1..9).toList().shuffled().take(3)
        this.computerNumber = numbers.joinToString("")
        println(this.computerNumber)
    }

}

fun main() {
    val gameManager: GameManager = GameManager()
    gameManager.setComputerNumber()
}
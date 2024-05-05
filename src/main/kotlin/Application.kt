class Application {
    private fun startNewGame(){
        val game = BaseballGame(ThreeDigits.fromList(Tools.permutation(3)))
        do{
            val input = getGuessInput()
        }while(!guessAndShowResult(input, game))

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    private fun askRetry():Boolean{
        while(true){
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val input = readln().toIntOrNull() ?: -1
            if(input == 1){
                return true
            }
            else if(input == 2){
                return false
            }
        }
    }

    private fun getGuessInput(): ThreeDigits {
        print("숫자를 입력해 주세요 : ")
        return ThreeDigits.fromList(Tools.strToIntegers(readln()))
    }
    private fun guessAndShowResult(input:ThreeDigits, game:BaseballGame):Boolean{
        val result = game.guess(input)
        println(result)
        return (result.strikes==3)
    }

    fun main(){
        do{
            startNewGame()
        } while(askRetry())
    }
}

fun main(){
    val app = Application()
    app.main()
}
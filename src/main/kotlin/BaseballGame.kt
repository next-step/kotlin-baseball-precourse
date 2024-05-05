class BaseballGame(private val answer:ThreeDigits) {
    private fun checkIfDigit(numberToCheck:Int):Boolean{
        return (numberToCheck < 10) and (numberToCheck >= 1)
    }
    private fun checkBall(numberToFind:Int, digit:Int):Boolean{
        if(!checkIfDigit(numberToFind))
            throw IllegalArgumentException("input number must be a non-zero digit")
        if((digit<0) or (digit>=3))
            throw IllegalArgumentException("input digit must between [0-2]")
        for(i in 0..2){
            if((answer[i] == numberToFind) and (i != digit))
                return true
        }
        return false
    }

    private fun checkStrike(numberToFind: Int, digit: Int):Boolean{
        if(!checkIfDigit(numberToFind))
            throw IllegalArgumentException("input number must be a non-zero digit")
        if((digit<0) or (digit>=3))
            throw IllegalArgumentException("input digit must between [0-2]")
        if(answer[digit] == numberToFind)
            return true
        return false
    }

    fun guess(input:ThreeDigits):BaseballGuessResult{
        var strikes = 0
        var balls = 0
        for(i in 0..2){
            if(checkStrike(input[i],i))
                strikes++
            else if(checkBall(input[i],i))
                balls++
        }
        return BaseballGuessResult(strikes,balls)
    }

    init{
        if((answer.digit1 == answer.digit2)
            or (answer.digit2 == answer.digit3)
            or (answer.digit1 == answer.digit3))
            throw IllegalArgumentException("the correct answer to the game should not contain duplicates")
    }
}
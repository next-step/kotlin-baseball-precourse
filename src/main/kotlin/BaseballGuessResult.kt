data class BaseballGuessResult(
    val strikes:Int,
    val balls:Int
){
    override fun toString():String{
        if((strikes == 0) and (balls == 0))
            return "낫싱"
        var result = ""
        if(balls>0)
            result += "${balls}볼"
        if(strikes>0)
            result += "${strikes}스트라이크"
        return result
    }
}

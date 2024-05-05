data class ThreeDigits(
    val digit1:Int,
    val digit2:Int,
    val digit3:Int
){
    operator fun get(i:Int):Int{
        if(i==0)
            return digit1
        if(i==1)
            return digit2
        if(i==2)
            return digit3
        throw IndexOutOfBoundsException()
    }

    init{
        if((digit1<1) or (digit1>=10))
            throw IllegalArgumentException("Each argument must be non-zero 1-digit integer.")
        if((digit2<1) or (digit2>=10))
            throw IllegalArgumentException("Each argument must be non-zero 1-digit integer.")
        if((digit3<1) or (digit3>=10))
            throw IllegalArgumentException("Each argument must be non-zero 1-digit integer.")
    }
    companion object{
        fun fromList(list:List<Int>):ThreeDigits{
            if(list.size!=3)
                throw IllegalArgumentException("invalid size of the input list.")
            return ThreeDigits(list[0], list[1], list[2])
        }
    }
}

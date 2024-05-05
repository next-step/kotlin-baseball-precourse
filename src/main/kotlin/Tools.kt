class Tools {
    companion object{
        fun strToIntegers(input:String):List<Int>{
            val list = mutableListOf<Int>()
            for(c in input){
                c.digitToIntOrNull()?.let{
                    list.add(it)
                }?:let{
                    throw IllegalArgumentException("Contains a character other than integer.")
                }
            }
            return list
        }
    }
}
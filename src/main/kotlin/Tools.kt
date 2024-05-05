import java.util.Random

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

        fun permutation(count:Int):List<Int>{
            if((count < 0) or (count>10))
                throw IllegalArgumentException("Number of permutation must between [0-10]")
            val rand = Random()
            val result = mutableListOf<Int>()
            val t = (0 .. 9).toMutableList()
            for(i in 0 until count){
                result.add(t.removeAt(rand.nextInt(0,t.size)))
            }

            return result
        }
    }
}
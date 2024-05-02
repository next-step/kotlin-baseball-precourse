class BaseballPlayer {
     var inputString: String = ""
        set(value: String) {
            field = checkValidation(value)
        }

    /** parameter로 넘어온 문자열이 정당한지 확인
     *  @details 정당하지 않다면,'IllegalArgumentException'를 발생
     *  @return 정당한 문자열을 반환 */
    fun checkValidation(value: String): String {
        // 1에서 9까지의 수로 이루어진 3자리의 수를 검출하는 정규 표현식(Regex)
        val validRegex: Regex = Regex("^[1-9][1-9][1-9]\$")

        // 미리 정의한 정규 표현식과 비교하여 match가 안되면, null 반환
        var regexResult: MatchResult? = validRegex.matchEntire(value)

        // match가 안되는 경우 -> Exception 발생
        if (regexResult == null) {
            throw IllegalArgumentException("올바르지 않은 입력입니다.")
        }

        // match가 된 경우 -> 원본 문자열을 그대로 반환
        return value
    }
}
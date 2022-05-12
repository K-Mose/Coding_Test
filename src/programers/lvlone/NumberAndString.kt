package programers.lvlone

/*
https://programmers.co.kr/learn/courses/30/lessons/81301?language=kotlin
코딩테스트 연습
2021 카카오 채용연계형 인턴십
숫자 문자열과 영단어
 */
fun main() {
    val sol = SolutionNumberAndString()
    sol.solution("one4seveneight")
    sol.solution("23four5six7")
    sol.solution("2three45sixseven")
    sol.solution("123")
}
class SolutionNumberAndString {
    fun solution(s: String): Int {
        val stringToNumberMap = hashMapOf(
            "zero" to 0,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9
        )
        var str = s
        stringToNumberMap.keys.forEach {
            str = str.replace(it, stringToNumberMap[it].toString())
        }
        return str.toInt()
    }
}
package programers.lvlone

/*
https://programmers.co.kr/learn/courses/30/lessons/76501?language=kotlin
코딩테스트 연습
월간 코드 챌린지 시즌2
음양 더하기

 */
fun main() {
    val sol = SolutionSumPoNeNumbers()
    println(sol.solution(intArrayOf(4,7,12), booleanArrayOf(true,false,true)))
    println(sol.solution(intArrayOf(1,2,3), booleanArrayOf(false,false,true)))
}
class SolutionSumPoNeNumbers {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int = absolutes.mapIndexed { index, i ->
        if (signs[index])
            i
        else
            -i
    }.sum()
}
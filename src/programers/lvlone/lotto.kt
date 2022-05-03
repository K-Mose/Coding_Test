package programers.lvlone
/*
https://programmers.co.kr/learn/courses/30/lessons/77484
코딩테스트 연습
2021 Dev-Matching: 웹 백엔드 개발자(상반기)
로또의 최고 순위와 최저 순위
 */
/*
    [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
    [0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
    [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]
 */

fun main() {
    val sol = Solution_lotto()
    sol.solution(intArrayOf(44, 1, 0, 0, 31, 25), intArrayOf(31, 10, 45, 1, 6, 19))
}

class Solution_lotto {
    val rankMap = hashMapOf(6 to 1, 5 to 2, 4 to 3, 3 to 4, 2 to 5, 1 to 6, 0 to 6)
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val unexpected = lottos.filter { it == 0 }.size
        val filtered = lottos.filter {
            it > 0 && win_nums.contains(it)
        }.size
        val high:Int = rankMap[filtered + unexpected]!!
        val low:Int = rankMap[filtered]!!
        answer = intArrayOf(high, low)
        return answer
    }
}
package programers.lvlone

/*
https://programmers.co.kr/learn/courses/30/lessons/64061?language=kotlin
코딩테스트 연습
2019 카카오 개발자 겨울 인턴십
크레인 인형뽑기 게임
 */

fun main() {
    val sol = SolutionCraneDoll()
    sol.solution(
        arrayOf(
            intArrayOf(0,0,0,0,0),
            intArrayOf(0,0,1,0,3),
            intArrayOf(0,2,5,0,1),
            intArrayOf(4,2,4,4,2),
            intArrayOf(3,5,1,3,1)
        ),
        intArrayOf(1,5,3,5,1,2,1,4)
    )
}

class SolutionCraneDoll {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        var board2 = board
        val resultQueue = ArrayDeque<Int>()
        moves.forEach {
            board2.firstOrNull { b ->
                b[it-1] > 0
            }?.also { b ->
                if (resultQueue.isNotEmpty()) {
                    if (resultQueue.last() == b[it-1]) {
                        resultQueue.removeLast()
                        answer += 1
                    }
                    else
                        resultQueue.addLast(b[it-1])
                } else
                    resultQueue.addLast(b[it-1])
                b[it-1] = 0
            }
        }
        println(resultQueue)
        println(answer)
        return answer * 2
    }

}
package programers.lvlone
import kotlin.math.abs

/*
https://programmers.co.kr/learn/courses/30/lessons/67256
코딩테스트 연습
2020 카카오 인턴십
키패드 누르기

4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
 */

fun main() {
    val sol = SolutionKeyPad()
    sol.solution(
        intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5),
        "right"
    )
//    sol.solution(
//        intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2),
//        "left"
//    )
}

class SolutionKeyPad {
    /*
    그래프 x , 해쉬
    왼손 오른손 포지션 잡고
    숫자간 거리 차 해쉬 미리 만들어서 계산
    1  2  3
    4  5  6
    7  8  9
   -1  0 -1
    start : left = -1, right = -1
     */
    fun solution(numbers: IntArray, hand: String): String {
        var left = -1
        var right = -1
        var answer = ""
        numbers.forEach {
            answer += when (it) {
                1, 4, 7 -> {
                    left = it
                    "L"
                }
                3, 6, 9 -> {
                    right = it
                    "R"
                }
                else -> {
                    when {
                        getDistance(left, it) == getDistance(right, it) -> {
                            if (hand == "right") {
                                right = it
                                "R"
                            } else {
                                left = it
                                "L"
                            }
                        }
                        getDistance(left, it) > getDistance(right, it) -> {
                            right = it
                            "R"
                        }
                        else -> {
                            left = it
                            "L"
                        }
                    }

                }
            }
        }
        println(answer)
        return answer
    }

    private fun getDistance(start: Int, target: Int): Int {
        val hashMap: HashMap<IntArray, Int> = hashMapOf(
            intArrayOf(-1, 2) to 4,
            intArrayOf(-1, 5) to 3,
            intArrayOf(-1, 8) to 2,
            intArrayOf(-1, 0) to 1,

            intArrayOf(0, 2) to 3,
            intArrayOf(0, 5) to 2,
            intArrayOf(0, 8) to 1,
            intArrayOf(0, 0) to 0,

            intArrayOf(1, 2) to 1,
            intArrayOf(1, 5) to 2,
            intArrayOf(1, 8) to 3,
            intArrayOf(1, 0) to 4,

            intArrayOf(4, 2) to 2,
            intArrayOf(4, 5) to 1,
            intArrayOf(4, 8) to 2,
            intArrayOf(4, 0) to 3,

            intArrayOf(7, 2) to 3,
            intArrayOf(7, 5) to 2,
            intArrayOf(7, 8) to 1,
            intArrayOf(7, 0) to 2,

            intArrayOf(3, 2) to 1,
            intArrayOf(3, 5) to 2,
            intArrayOf(3, 8) to 3,
            intArrayOf(3, 0) to 4,

            intArrayOf(6, 2) to 2,
            intArrayOf(6, 5) to 1,
            intArrayOf(6, 8) to 2,
            intArrayOf(6, 0) to 3,

            intArrayOf(9, 2) to 3,
            intArrayOf(9, 5) to 2,
            intArrayOf(9, 8) to 1,
            intArrayOf(9, 0) to 2,

            intArrayOf(2, 2) to 0,
            intArrayOf(2, 5) to 1,
            intArrayOf(2, 8) to 2,
            intArrayOf(2, 0) to 3,

            intArrayOf(5, 2) to 1,
            intArrayOf(5, 5) to 0,
            intArrayOf(5, 8) to 1,
            intArrayOf(5, 0) to 2,

            intArrayOf(8, 2) to 2,
            intArrayOf(8, 5) to 1,
            intArrayOf(8, 8) to 0,
            intArrayOf(8, 0) to 1,
        )
        return hashMap.keys.filter {
            (it[0] == start) and (it[1] == target)
        }.map {
            hashMap[it]
        }[0]!!.toInt()
    }
}
package programers.lvltwo
/*
https://programmers.co.kr/learn/courses/30/lessons/42888
코딩테스트 연습
2019 KAKAO BLIND RECRUITMENT
오픈채팅방
 */
fun main() {
    val sol = SolutionOpenChat()
    sol.solution(
        arrayOf(
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        )
    ).forEach {
        println(it)
    }
}

class SolutionOpenChat {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()
        val userMap: HashMap<String, String> = hashMapOf()
        answer += record
            .toList()
            .map {
                val userState = it.split(" ")
                when (userState[0]) {
                    "Enter" -> userMap[userState[1]] = userState[2]
                    "Change" -> userMap[userState[1]] = userState[2]
                }
                listOf(userState[0], userState[1])
            }
            .filter {
                it[0] != "Change"
            }.map {
                if (it[0] == "Enter") userMap[it[1]] + "님이 들어왔습니다."
                else userMap[it[1]] + "님이 나갔습니다."
            }
        return answer
    }
}
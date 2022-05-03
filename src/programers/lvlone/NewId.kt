package programers.lvlone

/*
https://programmers.co.kr/learn/courses/30/lessons/72410
코딩테스트 연습
2021 KAKAO BLIND RECRUITMENT
신규 아이디 추천

 */

fun main() {
    val sol = SolutionNewID()
    sol.solution("...!@BaT#*..y.abcdefghijklm")
    sol.solution("=.=")
    sol.solution(	"z-+.^.") // z-a
    sol.solution(	"123_.def")
    sol.solution(	"abcdefghijklmn.p")
//    println("12345678901234567890zz".split("").last())
}
/*
1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

꼬리재귀 or 내장함수
 */
class SolutionNewID {
    fun solution(new_id: String): String {
        val regex = Regex("[^a-z0-9._-]*")
        val doubleDot = Regex("\\.\\.")
        var answer: String = ""
        answer = new_id.split("")
            .map {
//                1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
//                2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            regex.replace(it.toLowerCase(), "")
        }
            .joinToString ("")
            .let {
//                3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
                var _it = it
                while(_it.contains(doubleDot)) {
                    _it = doubleDot.replace(_it, ".")
                }
//                4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
                while (_it.startsWith(".")) {
                    _it = _it.removePrefix(".")
                }
                while (_it.endsWith(".")) {
                    _it = _it.removeSuffix(".")
                }
//                5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
                while (_it.isEmpty()) {
                    _it = "a"
                }
//                6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//                        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
                if(_it.length > 15)
                    _it = _it.substring(0, 15)
                while (_it.startsWith(".")) {
                    _it = _it.removePrefix(".")
                }
                while (_it.endsWith(".")) {
                    _it = _it.removeSuffix(".")
                }
//                7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
                while (_it.length < 3) {
                    _it += _it.last()
                }
                _it
        }
        return answer
    }
}
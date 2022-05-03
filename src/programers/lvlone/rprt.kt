package programers.lvlone

import java.lang.reflect.Member

/*
https://programmers.co.kr/learn/courses/30/lessons/92334
코딩테스트 연습
2022 KAKAO BLIND RECRUITMENT
신고 결과 받기
 */
fun main() {
    val sol = Solution_rprt()
    print(sol.solution(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"), 2))
    print(sol.solution(arrayOf("con", "ryan"), arrayOf("ryan con", "ryan con", "ryan con", "ryan con"), 3).iterator())
}

class Solution_rprt {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val members: HashMap<String, MemberReport> = hashMapOf()
        var answer: IntArray = intArrayOf()
        val reportMap = HashMap<String, MutableList<String>>()
        val reporteeMap = HashMap<String, Int>()
        val memAry = arrayListOf<MemberReport>()
        for (m in id_list.iterator()) {
            val memR = MemberReport(m)
            memAry.add(memR)
            reportMap[m] = mutableListOf()
            reporteeMap[m] = 0
            members[m] = MemberReport(m)
        }

        val rptSet = reportSet(report)

        for (rs in rptSet.iterator()) {
            reportMap[rs[0]]!!.add(rs[1])
        }

        for (rm in reportMap.iterator()) {
            members[rm.key]!!.report = rm.value.toMutableList()
            rm.value.forEach {
                reporteeMap[it] = reporteeMap[it]!! + 1
                members[it]!!.apply {
                    if (reporteeMap[it] == k) banned = true
                    reported = reporteeMap[it]!!
                }
            }
        }

        // 리폿을 1이상인 사람 걸러서 Banned 당한 사람 리스트 비교 후 메일 발송
        val reporters = members.filter {
            it.value.report!!.isNotEmpty()
        }
        val banned = members.filter {
            it.value.banned
        }
        for (reporter in reporters) {
            reporter.value.report.forEach {
                if (banned.keys.contains(it)) {
                    reporter.value.result = reporter.value.result?.plus(1)
                }
            }
            members.forEach {
                if(it.key == reporter.key) {
                    it.value.report = reporter.value.report
                }
            }
        }
        var idx = 0
        val reportResultList = mutableListOf<Int>()
        // id_list 순으로 출력
        for (id in id_list.iterator()) {
            reportResultList.add(idx, members[id]!!.result)
            idx += 1
        }
        answer = reportResultList.toIntArray()
        return answer
    }

    private fun reportSet(report: Array<String>): HashSet<List<String>> {
        val rptSet = hashSetOf<List<String>>().apply {
            var rpt = report.iterator()
            while(rpt.hasNext()) {
                val rptAry = rpt.next().split(" ")
                add(rptAry)
            }
        }
        return rptSet
    }

    data class MemberReport(
        val member:String,
        var report: MutableList<String> = mutableListOf(),
        var result: Int = 0,
        var reported: Int? = 0,
        var banned: Boolean = false
    )
}


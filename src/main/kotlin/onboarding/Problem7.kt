package onboarding

import java.io.StringReader

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val originals = originalFriends(friends, user)
    val commonFriendsScoreMap = commonFriendScore(friends, originals, user)
    val visitScoreMap = visitScore(visitors, originals, user)

    return mergeToList(commonFriendsScoreMap, visitScoreMap)
}

fun mergeToList(common: Map<String, Int>, visitors: Map<String, Int>): List<String> {

    val merged = (common.keys + visitors.keys)
        .distinct()
        .associateWith {
            (common[it] ?: 0) + (visitors[it] ?: 0)
        }

    return merged.entries
        .sortedByDescending { it.value }
        .map { it.key }
}

fun originalFriends(friends: List<List<String>>, user: String): Set<String> {
    return friends
        .filter { it[1] == user || it[0] == user }
        .map {
            when {
                it[0] == user -> it[1]
                else -> it[0]
            } }
        .toSet()
}

fun commonFriendScore(friends: List<List<String>>, originals: Set<String>, user: String): Map<String, Int> {
    return friends
        .filter { it[0] in originals || it[1] in originals }
        .groupingBy {
            when {
                it[0] in originals -> it[1]
                else -> it[1]
            }
        }
        .eachCount()
        .filterKeys { it !in originals && it != user}
        .mapValues { (_, count) -> count*10 }
}

fun visitScore(visitors: List<String>, originals: Set<String>, user: String): Map<String, Int> {
    return visitors
        .groupingBy { it }
        .eachCount()
        .filterKeys { it !in originals && it != user}
}

fun main() {

    solution7("mrko", listOf(
        listOf("donut", "andole"),
        listOf("donut", "jun"),
        listOf("donut", "mrko"),
        listOf("shakevan", "andole"),
        listOf("shakevan", "jun"),
        listOf("shakevan", "mrko")
    ),
        listOf("bedi", "bedi", "donut", "bedi", "shakevan"))
}
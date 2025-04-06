package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val stored = buildSubstringMap(forms)
    return findDuplicatedEmails(forms, stored).sorted()
}

fun buildSubstringMap(forms: List<List<String>>): MutableMap<String, MutableList<Int>> {

    val stored = mutableMapOf<String, MutableList<Int>>()

    for (i in 0 ..forms.lastIndex) {
        val (_, nickname) = forms[i]
        for (j in 0 until nickname.length-1) {
            addSubstring(nickname.substring(j, j+2), i, stored)
        }
    }

    return stored
}

fun addSubstring(substring: String, idx: Int, stored: MutableMap<String, MutableList<Int>>)  {

    when {
        substring in stored -> stored[substring]?.add(idx)
        else -> stored[substring] = mutableListOf(idx)
    }
}

fun findDuplicatedEmails(forms: List<List<String>>, stored: MutableMap<String, MutableList<Int>>): HashSet<String> {
    val duplicatedEmails = HashSet<String>()
    for (substring in stored) {
        if (substring.value.size > 1) {
            for (idx in substring.value) {
                duplicatedEmails.add(forms[idx][0])
            }
        }
    }
    return duplicatedEmails
}

fun main() {
    solution6(listOf(
        listOf("jm@email.com", "제이엠"),
        listOf("jason@email.com", "제이슨"),
        listOf("woniee@email.com", "워니"),
        listOf("mj@email.com", "엠제이"),
        listOf("nowm@email.com", "이제엠")
    ))
}

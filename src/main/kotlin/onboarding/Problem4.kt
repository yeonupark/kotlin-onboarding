package onboarding

fun solution4(word: String): String {
    val result = StringBuilder()
    for (c in word) {
        result.append(
            when {
                c == ' ' -> ' '
                else -> convert(c)
            }
        )
    }
    return result.toString()
}

fun convert(letter: Char): Char {
    return when {
        letter.isUpperCase() -> (65 + 26 -letter.code + 64).toChar()
        letter.isLowerCase() -> (97 + 26 -letter.code + 96).toChar()
        else -> letter
    }
}

fun main() {
    print(solution4("I love you"))
}
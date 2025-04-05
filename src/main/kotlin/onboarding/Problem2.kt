package onboarding

fun solution2(cryptogram: String): String {
    val result = simplify(cryptogram)
    return result
}

fun simplify(cryptogram: String): String {

    val result = ArrayDeque<Char>()
    var temp = cryptogram[0]
    result.addLast(temp)

    for (i in 1 until cryptogram.length) {
        when {
            result.lastOrNull() == cryptogram[i] -> {
                temp = result.last()
                result.removeLast()
            }

            cryptogram[i] != temp -> {
                result.addLast(cryptogram[i])
            }
        }
    }

    return result.joinToString("")
}

fun main() {
    println(solution2("browoanooommnaon"))
}
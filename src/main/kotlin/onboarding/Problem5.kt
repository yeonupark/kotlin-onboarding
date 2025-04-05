package onboarding

fun solution5(money: Int): List<Int> {
    return divide(money, 50000)
}

fun divide(money: Int, divider: Int, result: MutableList<Int> = mutableListOf()): MutableList<Int> {
    result.add(money/divider)
    if (divider == 10) {
        result.add(money%divider)
        return result
    }
    return if (divider.toString()[0] == '5') {
        divide(money % divider, divider/5, result)
    } else {
        divide(money % divider, divider/2, result)
    }
}

fun main() {
    print(solution5(50237))
}
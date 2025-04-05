package onboarding

fun solution3(number: Int): Int {
    var ans = 0
    for (i in 1..number) {
        ans += clapCount(i)
    }
    return ans
}

fun clapCount(num: Int): Int {
    var remainder = num
    var result = 0

    while (remainder/10 > 0) {
        if ((remainder % 10) != 0 && (remainder%10) % 3 == 0) {
            result += 1
        }
        remainder /= 10
    }
    if (remainder % 3 == 0) {
        result += 1
    }

    return result
}

fun main() {
    print(solution3(33))
}
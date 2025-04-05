package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if (!isValidPage(pobi[0], pobi[1]) || !isValidPage(crong[0], crong[1])) {
        return -1
    }

    val pobiNum = maxOfEach(pobi[0], pobi[1])
    val crongNum = maxOfEach(crong[0], crong[1])

    if (pobiNum == crongNum) {
        return 0
    }
    if (pobiNum > crongNum) {
        return 1
    }
    if (pobiNum < crongNum) {
        return 2
    }
    return -1
}

fun separateDigits(num: Int): Array<Int> {
    val hundsDigit = num%100
    val tensDigit = (num/10) % 10
    val onesDigit = num % 10

    return arrayOf(onesDigit, tensDigit, hundsDigit)
}

fun sumOfDigits(digits: Array<Int>): Int {
    return digits[0] + digits[1] + digits[2]
}

fun productOfDigits(digits: Array<Int>): Int {
    for (i in 0..2) {
        if (digits[i] == 0) {
            digits[i] = 1
        }
    }
    return digits[0] * digits[1] * digits[2]
}

fun maxOfEach(left: Int, right: Int): Int {
    val maxBySum = maxOf(sumOfDigits(separateDigits(left)), sumOfDigits(separateDigits(right)))
    val maxByProduct = maxOf(productOfDigits(separateDigits(left)), productOfDigits(separateDigits(right)))
    return maxOf(maxBySum, maxByProduct)
}

fun isValidPage(left: Int, right: Int): Boolean {
    if (right - left < 0) {
        return false
    }
    if ((left < 2) or (right > 399)) {
        return false
    }
    if (right - left != 1) {
        return false
    }
    return true
}

fun main() {
    print(solution1(listOf(90, 91), listOf(197, 198)))
}
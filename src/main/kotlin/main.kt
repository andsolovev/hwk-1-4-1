const val ERROR_CARD = -1
const val ERROR_LIMIT = -2
const val AMOUNT_LIMIT_CARD = 150_000
const val PAST_TRANSFERS_LIMIT_CARD = 600_000
const val AMOUNT_LIMIT_VK = 15_000
const val PAST_TRANSFERS_LIMIT_VK = 40_000

fun main() {
    println(printFee(calculateFee("Mastercard", 30000, 20000)))
    println(printFee(calculateFee("Maestro", 70000, 15000)))
    println(printFee(calculateFee("Mastercard", 30000, 200000)))
    println(printFee(calculateFee("Visa", amount = 15000)))
    println(printFee(calculateFee(amount = 20000)))
    println(printFee(calculateFee("Master Card", 30000, 200000)))
}

fun calculateFee(accountType: String = "VK Pay", pastTransfers: Int = 0, amount: Int): Int {
    return when (accountType) {
        "Mastercard", "Maestro" ->  if (amount > AMOUNT_LIMIT_CARD || (pastTransfers + amount) > PAST_TRANSFERS_LIMIT_CARD) ERROR_LIMIT else if ((amount + pastTransfers) < 75_000) 0 else (((amount+pastTransfers-75_000) * 0.006)).toInt() + 20
        "Visa", "Мир" ->  if (amount > AMOUNT_LIMIT_CARD || (pastTransfers + amount) > PAST_TRANSFERS_LIMIT_CARD) ERROR_LIMIT else ((amount * 0.0075)).toInt() + 30
        "VK Pay" -> if (amount > AMOUNT_LIMIT_VK || (pastTransfers + amount) > PAST_TRANSFERS_LIMIT_VK) ERROR_LIMIT else 0
        else -> ERROR_CARD
    }
}

fun printFee(fee: Int): String {
    return when (fee) {
        ERROR_LIMIT -> "Превышен лимит!"
        ERROR_CARD -> "Введены некорректные данные"
        else -> "Комиссия за перевод составит $fee руб. Продолжить?"
    }
}
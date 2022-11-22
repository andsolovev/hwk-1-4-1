import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateFee_MC_amountLessThanLimits() {
        val accountType = "Mastercard"
        val pastTransfers = 30_000
        val amount = 20_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(0, result)
    }

    @Test
    fun calculateFee_MC_amountMoreThanLimits() {
        val accountType = "Mastercard"
        val pastTransfers = 30_000
        val amount = 200_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun calculateFee_MC_pastTransfersLessThanLimits() {
        val accountType = "Mastercard"
        val pastTransfers = 500_000
        val amount = 150_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun calculateFee_MC_pastTransfersMoreThanLimits() {
        val accountType = "Mastercard"
        val pastTransfers = 500_000
        val amount = 100_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(3170, result)

    }

    @Test
    fun calculateFee_MC_amountMoreThanFreeMonthTransfer() {
        val accountType = "Mastercard"
        val pastTransfers = 30_000
        val amount = 100_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(350, result)
    }

    @Test
    fun calculateFee_MC_amountMoreThanFreeMonthTransfer2() {
        val accountType = "Mastercard"
        val pastTransfers = 70_000
        val amount = 10_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(50, result)
    }

    @Test
    fun calculateFee_M_amountLessThanLimits() {
        val accountType = "Maestro"
        val pastTransfers = 30_000
        val amount = 20_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(0, result)
    }

    @Test
    fun calculateFee_M_amountMoreThanLimits() {
        val accountType = "Maestro"
        val pastTransfers = 30_000
        val amount = 200_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun calculateFee_M_pastTransfersLessThanLimits() {
        val accountType = "Maestro"
        val pastTransfers = 500_000
        val amount = 200_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun calculateFee_M_pastTransfersMoreThanLimits() {
        val accountType = "Maestro"
        val pastTransfers = 500_000
        val amount = 100_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(3170, result)

    }

    @Test
    fun calculateFee_M_amountMoreThanFreeMonthTransfer() {
        val accountType = "Maestro"
        val pastTransfers = 30_000
        val amount = 100_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(350, result)
    }

    @Test
    fun calculateFee_M_amountMoreThanFreeMonthTransfer2() {
        val accountType = "Maestro"
        val pastTransfers = 70_000
        val amount = 10_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(50, result)
    }

    @Test
    fun calculateFee_V_amountLessThanLimits() {
        val accountType = "Visa"
        val pastTransfers = 30_000
        val amount = 20_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(180, result)
    }

    @Test
    fun calculateFee_V_amountMoreThanLimits() {
        val accountType = "Visa"
        val pastTransfers = 30_000
        val amount = 200_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun calculateFee_V_pastTransfersLessThanLimits() {
        val accountType = "Visa"
        val pastTransfers = 500_000
        val amount = 200_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun calculateFee_V_pastTransfersMoreThanLimits() {
        val accountType = "Visa"
        val pastTransfers = 500_000
        val amount = 100_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(780, result)
    }

    @Test
    fun calculateFee_Mir_amountLessThanLimits() {
        val accountType = "Мир"
        val pastTransfers = 30_000
        val amount = 20_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(180, result)
    }

    @Test
    fun calculateFee_Mir_amountMoreThanLimits() {
        val accountType = "Мир"
        val pastTransfers = 30_000
        val amount = 200_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun calculateFee_Mir_pastTransfersLessThanLimits() {
        val accountType = "Мир"
        val pastTransfers = 500_000
        val amount = 150_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun calculateFee_Mir_pastTransfersMoreThanLimits() {
        val accountType = "Мир"
        val pastTransfers = 500_000
        val amount = 100_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(780, result)
    }

    @Test
    fun calculateFee_VK_amountLessThanLimits() {
        val accountType = "VK Pay"
        val pastTransfers = 0
        val amount = 10_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(0, result)
    }

    @Test
    fun calculateFee_VK_amountMoreThanLimits() {
        val accountType = "VK Pay"
        val pastTransfers = 30_000
        val amount = 15_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun calculateFee_VK_pastTransfersLessThanLimits() {
        val accountType = "VK Pay"
        val pastTransfers = 0
        val amount = 20_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun calculateFee_VK_pastTransfersMoreThanLimits() {
        val accountType = "VK Pay"
        val pastTransfers = 35_000
        val amount = 10_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun calculateFee_otherAccount() {
        val accountType = "Other"
        val pastTransfers = 10_000
        val amount = 10_000

        val result = calculateFee(accountType, pastTransfers, amount)

        assertEquals(-1, result)
    }

    @Test
    fun printFee_limitExceeded() {
        val fee = -2

        val result = printFee(fee)

        assertEquals("Превышен лимит!", result)
    }

    @Test
    fun printFee_incorrectData() {
        val fee = -1

        val result = printFee(fee)

        assertEquals("Введены некорректные данные", result)
    }

    @Test
    fun printFee_fee() {
        val fee = 100

        val result = printFee(fee)

        assertEquals("Комиссия за перевод составит $fee руб. Продолжить?", result)
    }
}

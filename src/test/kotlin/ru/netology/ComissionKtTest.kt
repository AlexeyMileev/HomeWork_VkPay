package ru.netology

import org.junit.Test

import org.junit.Assert.*

class ComissionKtTest {

    @Test
    fun comissionErrorDayLimit() {
        val typeCard = "Visa"
        val thisTransfer = 160_000
        val previosTransfer = 0
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(-2, result)
    }

    @Test
    fun comissionErrorMonthLimit() {
        val typeCard = "Visa"
        val thisTransfer = 160_000
        val previosTransfer = 500_000
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(-3, result)
    }

    @Test
    fun noComissionMasterCard() {
        val typeCard = "MasterCard"
        val thisTransfer = 70_000
        val previosTransfer = 0
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(0, result)
    }

    @Test
    fun comissionMasterCard() {
        val typeCard = "MasterCard"
        val thisTransfer = 120_000
        val previosTransfer = 10_000
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(350, result)
    }

    @Test
    fun noComissionMaestro() {
        val typeCard = "Maestro"
        val thisTransfer = 70_000
        val previosTransfer = 0
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(0, result)
    }

    @Test
    fun comissionMaestro() {
        val typeCard = "Maestro"
        val thisTransfer = 120_000
        val previosTransfer = 10_000
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(350, result)
    }

    @Test
    fun comissionVisa() {
        val typeCard = "Visa"
        val thisTransfer = 120_000
        val previosTransfer = 10_000
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(900, result)
    }

    @Test
    fun minComissionVisa() {
        val typeCard = "Visa"
        val thisTransfer = 1_000
        val previosTransfer = 0
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(35, result)
    }

    @Test
    fun comissionMir() {
        val typeCard = "Мир"
        val thisTransfer = 120_000
        val previosTransfer = 10_000
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(900, result)
    }

    @Test
    fun minComissionMir() {
        val typeCard = "Мир"
        val thisTransfer = 1_000
        val previosTransfer = 0
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(35, result)
    }

    @Test
    fun сomissionErrorOneLimitVkPay() {
        val typeCard = "VkPay"
        val thisTransfer = 16_000
        val previosTransfer = 0
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(-4, result)
    }

    @Test
    fun сomissionErrorMonthLimitVkPay() {
        val typeCard = "VkPay"
        val thisTransfer = 16_000
        val previosTransfer = 30_000
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(-5, result)
    }

    @Test
    fun сomissionVkPay() {
        val typeCard = "VkPay"
        val thisTransfer = 10_000
        val previosTransfer = 0
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(0, result)
    }

    @Test
    fun сomissionErrorTypeCahd() {
        val typeCard = "UnionPay"
        val thisTransfer = 10_000
        val previosTransfer = 0
        val result = comission(typeCard, thisTransfer, previosTransfer)
        assertEquals(-2, result)
    }

}
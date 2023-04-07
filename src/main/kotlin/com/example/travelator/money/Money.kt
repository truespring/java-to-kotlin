package com.example.travelator.money

import java.math.BigDecimal
import java.util.*

class Money
private constructor(
    val amount: BigDecimal,
    val currency: Currency
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val money = other as Money
        return amount == money.amount && currency == money.currency
    }

    override fun hashCode(): Int {
        return Objects.hash(amount, currency)
    }

    override fun toString(): String {
        return amount.toString() + " " + currency.currencyCode
    }

    fun add(that: Money): Money {
        require(currency == that.currency) { "cannot add Money values of different currencies" }
        return Money(amount + that.amount, currency)
    }

    companion object {
        @JvmStatic
        fun of(amount: BigDecimal, currency: Currency): Money {
            return Money(amount.setScale(currency.defaultFractionDigits), currency)
        }
    }
}
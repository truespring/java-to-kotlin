package com.example.travelator.moblie

import java.util.*

class PreferencesView : View() {
    private val greetingPicker = GreetingPicker()
    private val localePicker = LocalePicker()
    private val currencyPicker = CurrencyPicker()
    fun showModal(preferences: UserPreferences): UserPreferences {
        greetingPicker.greeting = preferences.greeting
        localePicker.locale = preferences.locale
        currencyPicker.currency = preferences.currency
        super.show()
        return UserPreferences(
            greetingPicker.greeting,
            localePicker.locale,
            currencyPicker.currency
        )
    }
}

internal class GreetingPicker {
    var greeting: String = ""
}

internal class LocalePicker {
    var locale: Locale = Locale.getDefault()
}

internal class CurrencyPicker {
    var currency: Currency = Currency.getInstance(Locale.getDefault())
}
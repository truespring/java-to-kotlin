package com.example.travelator.moblie

import java.util.*

data class UserPreferences (
    val greeting: String = "Hello",
    val locale: Locale = Locale.getDefault(),
    val currency: Currency = Currency.getInstance(Locale.getDefault())
)

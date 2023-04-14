package com.example.travelator.moblie

class Application(private var preferences: UserPreferences) {
    fun showWelcome() {
        WelcomeView(preferences).show()
    }

    fun editPreferences() {
        preferences = PreferencesView().showModal(preferences)
    }
}

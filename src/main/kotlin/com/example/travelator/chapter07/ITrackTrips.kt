package com.example.travelator.chapter07

import java.time.Instant

interface ITrackTrips {
    fun currentTripFor(customerId: String, at: Instant): Trip?
}

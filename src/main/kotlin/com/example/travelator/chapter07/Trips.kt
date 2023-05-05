package com.example.travelator.chapter07

import java.time.Instant

interface Trips {
    fun tripsFor(customerId: String): Set<Trip>
    fun currentTripsFor(customerId: String, at: Instant): Set<Trip>
}

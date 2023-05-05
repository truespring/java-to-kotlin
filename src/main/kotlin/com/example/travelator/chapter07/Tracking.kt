package com.example.travelator.chapter07

import com.example.travelator.chapter07.Trip.BookingStatus
import java.time.Instant
import java.util.stream.Collectors

class Tracking(private val trips: Trips) : ITrackTrips {
    override fun currentTripFor(customerId: String, at: Instant): Trip? {
        val candidates = trips.currentTripsFor(customerId, at).stream()
            .filter { trip: Trip -> trip.bookingStatus == BookingStatus.BOOKED }
            .collect(Collectors.toList())
        return when (candidates.size) {
            1 -> candidates[0]
            0 -> null
            else -> throw IllegalStateException("Multiple current trips for $customerId")
        }
    }
}

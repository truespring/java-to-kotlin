package com.example.travelator.chapter07.handlers

import com.example.travelator.chapter07.ITrackTrips
import com.example.travelator.chapter07.http.Request
import com.example.travelator.chapter07.http.Response
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.HttpURLConnection.*
import java.time.Clock

class CurrentTripsHandler(
    private val tracking: ITrackTrips,
    private val clock: Clock
) {
    private val objectMapper = ObjectMapper()
    fun handle(request: Request): Response {
        return try {
            val customerId = request.getQueryParam("customerId").firstOrNull()
                ?: return Response(HTTP_BAD_REQUEST)
            tracking.currentTripFor(customerId, clock.instant())?.let { currentTrip ->
                Response(
                    HTTP_OK,
                    objectMapper.writeValueAsString(currentTrip)
                )
            } ?: Response(HTTP_NOT_FOUND)
        } catch (e: Exception) {
            Response(HTTP_INTERNAL_ERROR)
        }
    }
}

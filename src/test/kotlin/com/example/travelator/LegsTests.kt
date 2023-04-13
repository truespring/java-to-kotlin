package com.example.travelator

import com.example.travelator.Legs.findLongestLegOver
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.*
import java.util.concurrent.ThreadLocalRandom

internal class LegsTests {

    private val legs = listOf(
        leg("one hour", Duration.ofHours(1)),
        leg("one day", Duration.ofDays(1)),
        leg("two hours", Duration.ofHours(2))
    )
    private val oneDay = Duration.ofDays(1)

    @Test
    fun is_absent_when_no_legs() {
        Assertions.assertEquals(
            Optional.empty<Any>(),
            findLongestLegOver(emptyList(), Duration.ZERO)
        )
    }

    @Test
    fun is_absent_when_no_legs_are_long_enough() {
        Assertions.assertEquals(
            Optional.empty<Any>(),
            findLongestLegOver(legs, oneDay)
        )
    }

    @Test
    fun is_longest_leg_when_one_match() {
        Assertions.assertEquals(
            "one day",
            findLongestLegOver(legs, oneDay.minusMillis(1))
                .orElseThrow().description
        )
    }

    @Test
    fun is_longest_leg_when_more_than_one_match() {
        Assertions.assertEquals(
            "one day",
            findLongestLegOver(legs, Duration.ofMinutes(59))
                .orElseThrow().description
        )
    }

    companion object {
        private fun leg(description: String, duration: Duration): Leg {
            val start = ZonedDateTime.ofInstant(
                Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt().toLong()),
                ZoneId.of("UTC")
            )
            return Leg(description, start, start.plus(duration))
        }
    }
}
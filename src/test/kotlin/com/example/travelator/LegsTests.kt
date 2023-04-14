package com.example.travelator

import com.example.travelator.Legs.longestLegOver
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.concurrent.ThreadLocalRandom

internal class LegsTests {

    private val legs = listOf(
        leg("one hour", Duration.ofHours(1)),
        leg("one day", Duration.ofDays(1)),
        leg("two hours", Duration.ofHours(2))
    )
    private val oneDay = Duration.ofDays(1)

    @Test
    fun `is absent when no legs`() {
        assertNull(legs.longestLegOver(emptyList(), Duration.ZERO))
    }

    @Test
    fun `is absent when no legs long enough`() {
        assertNull(legs.longestLegOver(legs, oneDay))
    }

    @Test
    fun `is longest leg when one match`() {
        assertEquals(
            "one day",
            legs.longestLegOver(legs, oneDay.minusMillis(1))
            !!.description
        )
    }

    @Test
    fun `is longest leg when more than one match`() {
        assertEquals(
            "one day",
            legs.longestLegOver(legs, Duration.ofMinutes(59))
            ?.description
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
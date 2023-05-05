package com.example.travelator;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.travelator.Suffering.longestJourneysIn;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

class LongestJourneyInTests {

    @Test
    public void returns_empty_list_for_empty_list() {
        assertEquals(emptyList(), longestJourneysIn(emptyList(), 2));
    }

    @Test
    public void returns_empty_list_for_0_limit() {
        assertEquals(emptyList(), longestJourneysIn(listOf(shortJourney), 0));
    }

    @Test
    public void returns_journey_sorted() {
        assertEquals(listOf(longJourney, mediumJourney, shortJourney), longestJourneysIn(listOf(shortJourney, mediumJourney, longJourney), 3));
    }

    @Test
    public void returns_limit_results() {
        assertEquals(listOf(longJourney, mediumJourney), longestJourneysIn(listOf(shortJourney, mediumJourney, longJourney), 2));
    }

    @Test
    public void returns_up_to_limit_results() {
        assertEquals(listOf(longJourney, mediumJourney, shortJourney), longestJourneysIn(listOf(shortJourney, mediumJourney, longJourney), 4));
    }
    
    @Test
    public void returns_immutable_list_results() {
        ArrayList<Journey> journeys = listOf(shortJourney, mediumJourney, longJourney);
        longestJourneysIn(journeys, 1);
        assertEquals(3, journeys.size());
    }

    private static ZonedDateTime now = ZonedDateTime.now();
    private Location somewhere = new Location();
    private Location somewhereElse = new Location();

    private final Journey shortJourney = new Journey(somewhere, somewhereElse, now, now.plusHours(1));
    private final Journey mediumJourney = new Journey(somewhere, somewhereElse, now, now.plusHours(2));
    private final Journey longJourney = new Journey(somewhere, somewhereElse, now, now.plusHours(3));

    private static <T> ArrayList<T> listOf(T... items) {
        return new ArrayList<T>(List.of(items));
    }
}
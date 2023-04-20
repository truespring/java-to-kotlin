package com.example.travelator

object Suffering {

    @JvmStatic
    fun sufferScoreFor(route: List<Journey>): Int {
        return sufferScore(
            route.longestJourneysIn(3),
            Routes.getDepartsFrom(route)
        )
    }

    @JvmStatic
    fun List<Journey>.longestJourneysIn(limit: Int): List<Journey> =
        sortedByDescending { it.duration }.take(limit)

    fun routesToShowFor(itineraryId: String?): List<List<Journey>> {
        return bearable(Other.routesFor(itineraryId))
    }

    fun bearable(routes: List<List<Journey>>) : List<List<Journey>> {
        return routes.filter { sufferScoreFor(it) <= 10 }
    }

    fun sufferScore(longestJourneys: List<Journey>?, start: Location?): Int {
        return Other.SOME_COMPLICATED_RESULT()
    }
}

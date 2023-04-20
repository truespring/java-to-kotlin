package com.example.travelator;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class UI {

    public static List<RouteRow> tableData(List<List<Journey>> routes) {
        return routes.stream()
                .map((route) ->
                        new RouteRow(route, Suffering.sufferScoreFor(route))
                ).collect(toList());
    }
}

class RouteRow {
    private final List<Journey> route;
    private final int sufferScore;

    public RouteRow(List<Journey> route, int sufferScore) {
        this.route = route;
        this.sufferScore = sufferScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteRow routeRow = (RouteRow) o;
        return sufferScore == routeRow.sufferScore && Objects.equals(route, routeRow.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, sufferScore);
    }
}

package com.example.travelator.chapter07.http;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Collections.emptyList;

public class Request {

    private final String body;
    private final Map<String, List<String>> queryParams;

    public Request(String body) {
        this(Map.of(), body);
    }

    public Request(Map<String, List<String>> queryParams) {
        this(queryParams, "");
    }

    public Request(Map<String, List<String>> queryParams, String body) {
        this.queryParams = queryParams;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(body, request.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    public List<String> getQueryParam(String name) {
        return queryParams.getOrDefault(name, emptyList());
    }
}

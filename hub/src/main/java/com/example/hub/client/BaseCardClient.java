package com.example.hub.client;

import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BaseCardClient extends BaseClient {

    public BaseCardClient(String baseUrl) {
        super(baseUrl);
    }

    protected <T> Mono<ClientResponse> getCards(String userId,
                                                BigDecimal longitude,
                                                BigDecimal latitude,
                                                Long currentDate,
                                                MediaType accept) {
        return this.getClient("/", createQuery(currentDate),
                createHeaders(userId, longitude, latitude).toSingleValueMap(), accept);
    }

    private static MultiValueMap<String, String> createHeaders(String userId, BigDecimal longitude, BigDecimal latitude) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("userId", userId);
        headers.add("longitude", longitude.toString());
        headers.add("latitude", latitude.toString());
        return headers;
    }

    private static Map<String, String> createQuery(Long currentDate) {
        Map<String, String> query = new HashMap<>();
        query.put("currentDate", currentDate.toString());
        return query;
    }
}

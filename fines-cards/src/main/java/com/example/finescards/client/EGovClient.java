package com.example.finescards.client;

import com.example.finescards.client.dto.FineDTO;
import com.example.finescards.client.dto.FinesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EGovClient {

    private final WebClient client;

    public EGovClient(@Value("${fines.egovURL}") String baseURL) {
        client = WebClient.create(baseURL);
    }

    public Mono<List<FineDTO>> getFines(String userId) {
//        return restTemplate.getForObject(baseURL + "/fines?userId={userId}", FinesResponse.class, userId);
        return client.get()
                .uri(uriBuilder -> uriBuilder.path("/fines").queryParam("userId",userId).build())
                .exchange()
                .flatMap(res -> res.bodyToMono(FinesResponse.class));
    }
}

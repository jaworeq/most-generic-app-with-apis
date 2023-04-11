package com.example.mostgenericappwithapis.handlers;

import com.example.mostgenericappwithapis.model.Generic;
import com.example.mostgenericappwithapis.service.GenericService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FirstApiHandler {
    @Value("${spring.r2dbc.url}")
    private String dbUrl;
    private final GenericService genericService;

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("Hello, spring! DB URL is: " + dbUrl), String.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(genericService.getAll(), Generic.class);
    }
}

package com.example.mostgenericappwithapis.router;


import com.example.mostgenericappwithapis.handlers.FirstApiHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class FirstApiRouter {

//    @Autowired
//    private final FirstApiHandler firstApiHandler;
    @Bean
    public RouterFunction<ServerResponse> route(FirstApiHandler firstApiHandler) {
        return RouterFunctions
                .route(GET("/hello")
                        .and(accept(MediaType.APPLICATION_JSON)),
                        firstApiHandler::hello
                        );
    }
}

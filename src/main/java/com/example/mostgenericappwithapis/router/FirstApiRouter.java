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
@RequiredArgsConstructor
public class FirstApiRouter {

    private final FirstApiHandler firstApiHandler;
    @Bean
    public RouterFunction<ServerResponse> firstRoute() {
        return RouterFunctions.nest(path("/v1"), route()
                .GET("/hello")
                        .and(accept(MediaType.APPLICATION_JSON)),
                        firstApiHandler::hello,
                       ops -> ops.tag("Swagger group")
                       .summary("Swagger summary")
                       .operationId("API function ID")
                       //.parameter(parameterBuilder().name("param-name").required(false).description("Param description").implementation(String.class).in(ParameterIn.QUERY).example("example value"))
                       //.response(responseBuilder().responseCode("200").content(contentBuilder().mediaType.APPLICATION_JSON_VALUE).schema(schemaBuilder().implementation(Long.class))))
                       //.response(responseBuilder().responseCode("400").description("Bad Request").implementation(ResponseError.class))
                        );
    }
}

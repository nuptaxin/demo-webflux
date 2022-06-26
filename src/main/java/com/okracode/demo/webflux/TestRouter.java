package com.okracode.demo.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Eric Ren
 * @date 2022/6/26
 */
@Configuration
public class TestRouter {

    @Bean
    public RouterFunction<ServerResponse> routeExample() {
        return RouterFunctions.route(
                RequestPredicates.GET("/hello/webflux").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                serverRequest -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).bodyValue("hello webflux!")
                        .switchIfEmpty(ServerResponse.notFound().build()));
    }
}

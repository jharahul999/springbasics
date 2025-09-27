package com.rahul.boot.springbasics;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    void testMono() {
        Mono<Object> stringMono = Mono.just("RAHUL")
                .then(Mono.error(new RuntimeException("Error on ")))
                .log();
        stringMono.subscribe(System.out::println, (e) -> System.out.println("Occurred " + e.getMessage()));
    }

    @Test
    void testFlux() {
        Flux<String> flux = Flux.just("Spring", "Boot", "hibernate")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Error on Flux")))
                .concatWithValues("Cloud")//Wont be printed
                .log();
        flux.subscribe(System.out::println, (e) -> System.out.println("Occurred " + e.getMessage()));
    }
}

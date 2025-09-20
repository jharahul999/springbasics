package com.rahul.boot.springbasics;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    void testMono() {
        Mono<String> stringMono = Mono.just("RAHUL").log();
        stringMono.subscribe(System.out::println);
    }
}

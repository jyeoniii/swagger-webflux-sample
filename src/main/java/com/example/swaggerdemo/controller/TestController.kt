package com.example.swaggerdemo.controller

import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

class Wrapper<T>(t: T)
class Model

@RestController
class TestController {
    @GetMapping(value = ["/friend"], produces = ["application/json"])
    fun getFriendList(): Mono<Page<Model>> {
        return Mono.just(Page.empty())
    }

    @GetMapping(value = ["/favorite"], produces = ["application/json"])
    fun getFavorites(): Mono<Page<Model>> {
        return Mono.just(Page.empty())
    }
}

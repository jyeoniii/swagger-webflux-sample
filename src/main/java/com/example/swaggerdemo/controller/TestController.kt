package com.example.swaggerdemo.controller

import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

class Wrapper<T>(t: T)
class Model

@RestController
class TestController {
    @GetMapping(value = ["/friend"], produces = ["application/json"])
    fun getFriendList(): Mono<Wrapper<Page<Model>>> {
        return Mono.just(
            Wrapper(
                Page.empty()
            )
        )
    }

    @GetMapping(value = ["/favorite"], produces = ["application/json"])
    fun getFavorites(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int
    ): Mono<Wrapper<Page<Model>>> {
        return Mono.just(
            Wrapper(
                Page.empty()
            )
        )
    }
}

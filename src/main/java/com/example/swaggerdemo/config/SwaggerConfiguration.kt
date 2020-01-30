package com.example.swaggerdemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux
import java.security.Timestamp
import java.util.Collections.emptyList

@Configuration
@EnableSwagger2WebFlux
open class SwaggerConfiguration {
    @Bean
    open fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .directModelSubstitute(Timestamp::class.java, Long::class.java)
            .useDefaultResponseMessages(false)
            .ignoredParameterTypes(ServerWebExchange::class.java)
            .apiInfo(apiInfo())
            .genericModelSubstitutes(Flux::class.java, Mono::class.java)
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
            "Swagger Test",
            "Test",
            "1.0.0",
            null,
            null,
            "XXX",
            null, emptyList()
        )
    }


}

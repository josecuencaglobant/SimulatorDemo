package com.simulator.demo.configuration

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync

/**
 * This is the entry point for the global spring configuration. The only beans that should be defined directly here
 * should be common beans that have no dependencies outside of this class.
 */
@ImportAutoConfiguration(
    value = [
        GraphQLConfiguration::class,
        WebSocketServletAutoConfiguration::class,
        JacksonAutoConfiguration::class,
    ]
)
@Configuration
@EnableAsync
class SpringConfiguration

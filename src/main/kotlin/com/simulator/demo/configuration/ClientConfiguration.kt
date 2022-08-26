package com.simulator.demo.configuration

import com.simulator.demo.proxy.GetRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientConfiguration {

    @Bean
    fun symbolsProxy() = GetRequest("https://lermaserver.com")

}
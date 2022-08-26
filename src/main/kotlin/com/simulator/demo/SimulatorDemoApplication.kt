package com.simulator.demo

import com.simulator.demo.configuration.SpringConfiguration
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@ImportAutoConfiguration(SpringConfiguration::class)
class SimulatorDemoApplication

fun main(args: Array<String>) {
	runApplication<SimulatorDemoApplication>(*args)
}

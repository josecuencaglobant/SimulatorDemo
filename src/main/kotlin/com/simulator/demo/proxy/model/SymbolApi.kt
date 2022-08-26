package com.simulator.demo.proxy.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SymbolApi(
    @JsonProperty("code")
    val code: String,
    @JsonProperty("x")
    val x: Long,
    @JsonProperty("y")
    val y: Long
)
package com.simulator.demo.proxy.model

import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription("SymbolResponse")
data class SymbolResponse(
    @GraphQLDescription("code")
    val code: String,
    @GraphQLDescription("x")
    val x: String,
    @GraphQLDescription("y")
    val y: String
)
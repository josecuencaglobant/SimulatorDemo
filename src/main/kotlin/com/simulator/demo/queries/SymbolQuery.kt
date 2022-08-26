package com.simulator.demo.queries

import com.expediagroup.graphql.server.operations.Query
import com.simulator.demo.proxy.model.Symbol
import org.springframework.stereotype.Component

@Component
class SymbolQuery: Query {

    fun symbol(code: String) = Symbol(code)

}
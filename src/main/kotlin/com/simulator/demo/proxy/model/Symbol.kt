package com.simulator.demo.proxy.model

import com.expediagroup.graphql.server.extensions.getValueFromDataLoader
import com.simulator.demo.dataloaders.SYMBOL_DATA_LOADER
import graphql.schema.DataFetchingEnvironment
import java.util.concurrent.CompletableFuture

data class Symbol(val code: String){
    fun getInfo(dataFetchingEnvironment: DataFetchingEnvironment): CompletableFuture<SymbolResponse>{
        return dataFetchingEnvironment.getValueFromDataLoader<String, SymbolApi>(SYMBOL_DATA_LOADER, code).thenApply {
            SymbolResponse(
                code = it.code,
                x = it.x.toString(),
                y = it.y.toString()
            )
        }
    }
}
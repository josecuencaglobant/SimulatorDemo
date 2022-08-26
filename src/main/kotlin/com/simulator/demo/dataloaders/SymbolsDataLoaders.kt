package com.simulator.demo.dataloaders

import com.expediagroup.graphql.dataloader.KotlinDataLoader
import com.simulator.demo.proxy.GetRequest
import com.simulator.demo.proxy.model.SymbolApi
import org.dataloader.DataLoader
import org.dataloader.DataLoaderFactory
import java.util.concurrent.CompletableFuture

const val SYMBOL_DATA_LOADER = "SymbolDataLoader"

class SymbolsDataLoaders(
    private val symbolsProxy: GetRequest
): KotlinDataLoader<String, SymbolApi>{
    override val dataLoaderName: String
        get() = SYMBOL_DATA_LOADER

    override fun getDataLoader(): DataLoader<String, SymbolApi> =
        DataLoaderFactory.newDataLoader {
            ids -> CompletableFuture.supplyAsync {
                println("Getting Ids: $ids")
                symbolsProxy.getSymbols(ids)
        }
        }
}
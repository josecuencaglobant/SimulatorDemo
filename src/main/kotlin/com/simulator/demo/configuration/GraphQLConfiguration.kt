package com.simulator.demo.configuration

import com.expediagroup.graphql.dataloader.KotlinDataLoaderRegistryFactory
import com.expediagroup.graphql.dataloader.instrumentation.level.DataLoaderLevelDispatchedInstrumentation
import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.toSchema
import com.expediagroup.graphql.server.spring.GraphQLConfigurationProperties
import com.simulator.demo.dataloaders.SymbolsDataLoaders
import com.simulator.demo.proxy.GetRequest
import com.simulator.demo.queries.SymbolQuery
import graphql.GraphQL
import graphql.schema.GraphQLSchema
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(GraphQLConfigurationProperties::class)
class GraphQLConfiguration(
    private val symbolsProxy: GetRequest
) {

    @Bean
    fun schema(
        symbolQuery: SymbolQuery
    ): GraphQLSchema {
        return toSchema(
            queries = listOf(TopLevelObject(symbolQuery)),
            config = SchemaGeneratorConfig(
                supportedPackages = listOf("com.simulator.demo"),
            )
        )
    }

    @Bean
    fun dataLoader() = KotlinDataLoaderRegistryFactory(SymbolsDataLoaders(symbolsProxy))

    @Bean
    fun graphQL(schema: GraphQLSchema) = GraphQL.Builder(schema)
        .doNotAddDefaultInstrumentations()
        .instrumentation(DataLoaderLevelDispatchedInstrumentation())
        .build()

}
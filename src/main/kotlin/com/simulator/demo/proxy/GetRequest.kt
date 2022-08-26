package com.simulator.demo.proxy

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.simulator.demo.proxy.model.SymbolApi
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GetRequest(
    private val url: String
) {

    private val client = HttpClient.newBuilder().build()
    private val mapper = ObjectMapper()

    fun getSymbols(symbols: List<String>): List<SymbolApi?>? {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("$url/public/simulator/${symbols.joinToString(",")}"))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        return mapper.readValue(response.body(), object : TypeReference<List<SymbolApi?>?>() {} )
    }

}
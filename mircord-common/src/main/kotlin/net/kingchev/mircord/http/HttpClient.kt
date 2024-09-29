package net.kingchev.mircord.http

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import net.kingchev.mircord.http.config.RequestConfig

internal class HttpClient(private val token: String) {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation)
    }

    private fun format(template: String, map: Map<String, String>): String = map.entries.fold(template) { acc, entry ->
        acc.replace("{${entry.key}}", entry.value)
    }

    internal suspend fun request(route: Route, config: RequestConfig.() -> Unit): HttpResponse {
        val builtConfig = RequestConfig().apply(config)

        val url = if (builtConfig.parameters.isNotEmpty()) {
            format(route.endpoint, builtConfig.parameters)
        } else route.endpoint

        val response = client.request(BASE_URL + url) {
            method = route.method
            contentType(builtConfig.contentType)
            headers {
                "Authorization" to token
            }
            if (builtConfig.body != null) {
                setBody(builtConfig.body)
            }

            builtConfig.headers.forEach { header(it.key, it.value) }
        }
        return response
    }
}
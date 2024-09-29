package net.kingchev.mircord.http.config

import io.ktor.http.*

internal class RequestConfig {
    internal var headers: Map<String, String> = emptyMap()
    internal var body: String? = null
    internal var contentType: ContentType = ContentType.Application.Json
    internal var parameters: MutableMap<String, String> = mutableMapOf()

    fun headers(block: HeaderBuilder.() -> Unit) {
        headers = HeaderBuilder().apply(block).build()
    }

    fun params(vararg parameter: Pair<String, String>) =
        parameter.forEach { parameters[it.first] = it.second }
}
package net.kingchev.mircord.http.config

internal class HeaderBuilder {
    private val headers: MutableMap<String, String> = mutableMapOf()

    internal infix fun String.to(value: String) {
        headers[this] = value
    }

    internal fun build(): Map<String, String> = headers.toMap()
}
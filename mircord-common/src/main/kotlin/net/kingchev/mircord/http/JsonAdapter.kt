package net.kingchev.mircord.http

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal object JsonAdapter {
    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    internal inline fun <reified T> stringify(data: T): String = json.encodeToString(data)

    internal inline fun <reified T> jsonify(data: String): T = json.decodeFromString<T>(data)
}
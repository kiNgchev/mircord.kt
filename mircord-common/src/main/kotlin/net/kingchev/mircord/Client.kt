package net.kingchev.mircord

import kotlinx.coroutines.*
import net.kingchev.mircord.entity.BotStats
import net.kingchev.mircord.http.HttpClient
import net.kingchev.mircord.http.JsonAdapter
import net.kingchev.mircord.http.STATUS_UPDATE

/**
 * The core of Mircord.kt. Mircord API client gives access to all parts of the API.
 *
 * @author kiNgchev
 */
public class Client internal constructor(private val token: String) {
    init {
        if (token.isBlank() && token.isEmpty()) throw IllegalArgumentException("Token cannot be empty")
    }

    private val http: HttpClient = HttpClient(token)

    /**
     * Update bot statistics to mircord API
     *
     * @param stats: [BotStats] - Bot statistic, that needs to be updated
     * @return [Unit]
     * @throws [Exception]
     * @author kiNgchev
     */
    public suspend fun updateStatistics(stats: BotStats) {
        val route = STATUS_UPDATE
        val responce = http.request(route) {
            body = JsonAdapter.stringify<BotStats>(stats)
        }
        if (responce.status.value != 200) throw Exception("${responce.status.value}: ${responce.status.description}")
    }
}

/**
 * Is the function, that you need to create [Client] object
 *
 * @param token: [String] - A mircord token, that you need to
 * @return [Deferred]<[Client]>
 * @author kiNgchev
 */
@OptIn(DelicateCoroutinesApi::class)
public fun mircord(token: String): Deferred<Client> = mircord(token, GlobalScope)

/**
 * Is overloading function [mircord]
 *
 * @param token: [String] - A mircord token, that you need to
 * @param scope: [CoroutineScope] - A coroutine scope, in which the coroutine will be executed
 * @return [Deferred]<[Client]>
 * @author kiNgchev
 */
public fun mircord(token: String, scope: CoroutineScope): Deferred<Client> = scope.async { Client(token) }

/**
 * Is overloading function [mircord]
 *
 * @param token: [String] - A mircord token, that you need to
 * @param block - Lambda that will execute and return result
 * @return [Deferred]<[T]>
 * @author kiNgchev
 */
@OptIn(DelicateCoroutinesApi::class)
public fun <T> mircord(
    token: String,
    block: suspend Client.() -> T
): Deferred<T> = mircord(token, GlobalScope, block)

/**
 * Is overloading function [mircord]
 *
 * @param token: [String] - A mircord token, that you need to
 * @param scope: [CoroutineScope] - A coroutine scope, in which the coroutine will be executed
 * @param block - Lambda that will execute and return result
 * @return [Deferred]<[T]>
 * @author kiNgchev
 */
public fun <T> mircord(
    token: String,
    scope: CoroutineScope,
    block: suspend Client.() -> T
): Deferred<T> = scope.async { Client(token).block() }

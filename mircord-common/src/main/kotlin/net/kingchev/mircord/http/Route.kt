package net.kingchev.mircord.http

import io.ktor.http.*
import net.kingchev.mircord.entity.BotStats
import kotlin.reflect.KClass

internal const val BASE_URL = "https://mircord.xyz/api"

internal data class Route(val endpoint: String, val method: HttpMethod, val clazz: KClass<*>)

internal val STATUS_UPDATE = Route("/stats-update", HttpMethod.Post, BotStats::class)
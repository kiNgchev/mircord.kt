package net.kingchev.mircord.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The bot statistic entity
 *
 * @author kiNgchev
 */
@Serializable
public class BotStats {
    /**
     * The count of bot servers
     *
     * @author kiNgchev
     */
    @SerialName("servers")
    public var servers: Int = 0; private set

    /**
     * The count of bot shards
     *
     * @author kiNgchev
     */
    @SerialName("shards")
    public var shards: Int = 0; private set

    public fun shards(shards: Int): BotStats = apply { this.shards = shards }

    public fun servers(servers: Int): BotStats = apply { this.servers = servers }
}

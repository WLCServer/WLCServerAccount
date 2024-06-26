package cc.wlcs.wlcserveraccount.listener

import cc.wlcs.wlcserveraccount.WLCServerAccount
import cc.wlcs.wlcserveraccount.entity.Account
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.connection.DisconnectEvent
import com.velocitypowered.api.event.player.ServerPostConnectEvent
import java.time.LocalDateTime

class PlayerListener {

    @Subscribe
    fun onServerPostConnect(event: ServerPostConnectEvent) {
        val player = event.player
        val account = Account(uuid = player.uniqueId)
        if (account.exist()) {
            if (account.isBanned()) {
                TODO("Banned kick message")
            } else {
                account.setLastLoginTime(LocalDateTime.now())
            }
        } else {
            account.add(player)
            val lang = WLCServerAccount.langConfig.getConfigData()
            player.sendMessage(
                WLCServerAccount.miniMessage.deserialize(
                    lang.prefix() + lang.firstJoinMessage().replace("%id%", account.getWid().toString())
                )
            )
        }
    }

    @Subscribe
    fun onDisconnect(event: DisconnectEvent) {
        val player = event.player
        val account = Account(uuid = player.uniqueId)
        if (account.exist()) {
            account.setLastLogoutTime(LocalDateTime.now())
        }
    }

}
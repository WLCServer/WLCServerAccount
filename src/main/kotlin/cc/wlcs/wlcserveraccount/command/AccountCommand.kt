package cc.wlcs.wlcserveraccount.command

import cc.wlcs.wlcserveraccount.WLCServerAccount
import cc.wlcs.wlcserveraccount.entity.Account
import cc.wlcs.wlcserveraccount.inventory.AccountInv
import com.velocitypowered.api.command.SimpleCommand
import com.velocitypowered.api.proxy.Player

class AccountCommand : SimpleCommand {

    override fun execute(invocation: SimpleCommand.Invocation) {
        if (invocation.source() is Player) {
            val player = invocation.source() as Player
            if (invocation.arguments().isEmpty()) {
                AccountInv(player).open()
            } else {
                when (invocation.arguments()[0]) {
                    "set" -> {
                        if (invocation.arguments().size == 3) {
                            TODO("Set account")
                            when (invocation.arguments()[1]) {

                            }
                        }
                    }
                    "info" -> {
                        val account = Account(uuid = player.uniqueId)
                        player.sendMessage(
                            WLCServerAccount.miniMessage.deserialize(
                                WLCServerAccount.langConfig.getConfigData().infoCommand()
                                    .replace("%wid%", account.getWid().toString())
                                    .replace("%name%", account.getPlayerName())
                                    .replace("%uuid%", account.getPlayerUniqueId().toString())
                                    .replace("%gender%", account.getGender())
                                    .replace("%qq%", account.getQQ().toString())
                                    .replace("%email%", account.getEmail().toString())
                                    .replace("%phone%", account.getPhone().toString())

                            )
                        )
                    }
                }
            }
        }
    }

}
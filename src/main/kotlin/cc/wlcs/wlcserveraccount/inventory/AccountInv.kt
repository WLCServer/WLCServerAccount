package cc.wlcs.wlcserveraccount.inventory

import cc.wlcs.wlcserveraccount.WLCServerAccount
import cc.wlcs.wlcserveraccount.entity.Account
import cn.hutool.core.util.DesensitizedUtil
import cn.hutool.core.util.StrUtil
import com.velocitypowered.api.proxy.Player
import dev.simplix.protocolize.api.Protocolize
import dev.simplix.protocolize.api.chat.ChatElement
import dev.simplix.protocolize.api.inventory.Inventory
import dev.simplix.protocolize.api.item.ItemStack
import dev.simplix.protocolize.data.ItemType
import dev.simplix.protocolize.data.inventory.InventoryType

class AccountInv(private val player: Player) {


    fun open() {
        val lang = WLCServerAccount.langConfig.getConfigData()
        val account = Account(uuid = player.uniqueId)
        val inventory = Inventory(InventoryType.GENERIC_9X4).title(
            ChatElement.of(
                WLCServerAccount.miniMessage.deserialize(lang.guiTitle())
            )
        )
        val widItem = ItemStack(ItemType.DIAMOND)
        widItem.displayName(
            ChatElement.of(
                WLCServerAccount.miniMessage.deserialize(
                    lang.guiWidItemName()
                        .replace("%wid%", account.getWid().toString())
                )
            )
        )
        inventory.item(10, widItem)
        val nameItem = ItemStack(ItemType.NAME_TAG)
        nameItem.displayName(
            ChatElement.of(
                WLCServerAccount.miniMessage.deserialize(
                    lang.guiNameItemName()
                        .replace("%name%", account.getPlayerName())
                )
            )
        )
        inventory.item(11, nameItem)
        val uuidItem = ItemStack(ItemType.SUGAR)
        uuidItem.displayName(
            ChatElement.of(
                WLCServerAccount.miniMessage.deserialize(
                    lang.guiUuidItemName()
                        .replace("%uuid%", account.getPlayerUniqueId().toString())
                )
            )
        )
        inventory.item(12, uuidItem)
        val genderItem = ItemStack(ItemType.ARROW)
        genderItem.displayName(
            ChatElement.of(
                WLCServerAccount.miniMessage.deserialize(
                    lang.guiGenderItemName()
                        .replace("%gender%", account.getGender())
                )
            )
        )
        inventory.item(13, genderItem)
        val qqItem = ItemStack(ItemType.REDSTONE)
        qqItem.displayName(
            ChatElement.of(
                WLCServerAccount.miniMessage.deserialize(
                    lang.guiQQItemName()
                        .replace("%qq%", account.getQQ().toString())
                )
            )
        )
        inventory.item(14, qqItem)
        val emailItem = ItemStack(ItemType.PAPER)
        emailItem.displayName(
            ChatElement.of(
                WLCServerAccount.miniMessage.deserialize(
                    lang.guiEmailItemName()
                        .replace("%email%", DesensitizedUtil.email(account.getEmail().toString()))
                )
            )
        )
        inventory.item(15, emailItem)
        val phoneItem = ItemStack(ItemType.GOAT_HORN)
        phoneItem.displayName(
            ChatElement.of(
                WLCServerAccount.miniMessage.deserialize(
                    lang.guiPhoneItemName()
                        .replace("%phone%", StrUtil.hide(account.getPhone().toString(), 1, 10))
                )
            )
        )
        inventory.item(16, phoneItem)
        val birthdayItem = ItemStack(ItemType.CAKE)
        birthdayItem.displayName(
            ChatElement.of(
                WLCServerAccount.miniMessage.deserialize(
                    lang.guiBirthdayItemName()
                        .replace("%birthday%", account.getBirthday().toString())
                )
            )
        )
        inventory.item(20, birthdayItem)
        val registerTimeItem = ItemStack(ItemType.COMPASS)
        registerTimeItem.displayName(
            ChatElement.of(
                WLCServerAccount.miniMessage.deserialize(
                    lang.guiRegisterTimeItemName()
                        .replace("%register_time%", account.getRegisterTime().toString())
                )
            )
        )
        inventory.item(24, registerTimeItem)
        Protocolize.playerProvider().player(player.uniqueId).openInventory(inventory)
    }

}
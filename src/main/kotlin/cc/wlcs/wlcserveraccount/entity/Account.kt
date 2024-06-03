package cc.wlcs.wlcserveraccount.entity

import cc.wlcs.wlcserveraccount.WLCServerAccount
import cc.wlcs.wlcserveraccount.database.Account
import cc.wlcs.wlcserveraccount.database.Accounts.accounts
import cc.wlcs.wlcserveraccount.database.Accounts.get
import cc.wlcs.wlcserveraccount.database.Ban
import cc.wlcs.wlcserveraccount.database.Bans.bans
import cc.wlcs.wlcserveraccount.database.Warning
import cc.wlcs.wlcserveraccount.database.Warnings.warning
import cc.wlcs.wlcserveraccount.database.Warnings.warnings
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.velocitypowered.api.proxy.Player
import net.kyori.adventure.text.Component
import org.ktorm.dsl.*
import org.ktorm.entity.add
import org.ktorm.entity.find
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class Account(val wid: Int? = null, val name: String? = null, val uuid: UUID? = null) {

    fun exist(): Boolean {
        return WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        } != null
    }

    fun add(player: Player): Boolean {
        WLCServerAccount.database.accounts
            .add(Account {
                name = player.username
                uuid = player.uniqueId.toString()
                registerIp = player.remoteAddress.hostName
                registerTime = LocalDateTime.now()
                lastLoginTime = LocalDateTime.now()
            })
        WLCServerAccount.database.warnings
            .add(Warning {
                name = player.username
                uuid = player.uniqueId.toString()
            })
        WLCServerAccount.database.bans
            .add(Ban {
                name = player.username
                uuid = player.uniqueId.toString()
                banned = false
            })
        return true
    }

    fun getWid(): Int {
        val identifier = when {
            wid != null -> return wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.wid ?: throw NullPointerException("The account does not exist")
    }

    fun getPlayerName(): String {
        return WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.name ?: throw NullPointerException("The account does not exist")
    }

    fun setPlayerName(playerName: String): Boolean {
        WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.also {
            it.name = playerName
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun getPlayerUniqueId(): UUID {
        return UUID.fromString(WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.uuid ?: throw NullPointerException("The account does not exist"))
    }

    fun setPlayerUniqueId(playerUniqueId: UUID): Boolean {
        WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.also {
            it.uuid = playerUniqueId.toString()
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun getGender(): String {
        return WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.gender ?: throw NullPointerException("The account does not exist")
    }

    fun setGender(gender: String): Boolean {
        WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.also {
            it.gender = gender
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun getQQ(): String? {
        return WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.qq
    }

    fun setQQ(qq: String): Boolean {
        WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.also {
            it.qq = qq
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun getEmail(): String? {
        return WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.email
    }

    fun setEmail(email: String): Boolean {
        WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.also {
            it.email = email
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun getPhone(): String? {
        return WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.phone
    }

    fun setPhone(phone: String): Boolean {
        WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.also {
            it.phone = phone
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun getBirthday(): LocalDate? {
        return WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.birthday
    }

    fun setBirthday(birthday: LocalDate): Boolean {
        WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.also {
            it.birthday = birthday
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun getRegisterIp(): String {
        return WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.registerIp ?: throw NullPointerException("The account does not exist")
    }

    fun setRegisterIp(ip: String): Boolean {
        WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.also {
            it.registerIp = ip
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun getRegisterTime(): LocalDateTime {
        return WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.registerTime ?: throw NullPointerException("The account does not exist")
    }

    fun setRegisterTime(time: LocalDateTime): Boolean {
        WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.also {
            it.registerTime = time
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun getLastLoginTime(): LocalDateTime {
        return WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.lastLoginTime ?: throw NullPointerException("The account does not exist")
    }

    fun setLastLoginTime(time: LocalDateTime): Boolean {
        WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.also {
            it.lastLoginTime = time
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun getLastLogoutTime(): LocalDateTime? {
        return WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.lastLogoutTime
    }

    fun setLastLogoutTime(time: LocalDateTime): Boolean {
        WLCServerAccount.database.accounts.find {
            it.wid eq getWid()
        }?.also {
            it.lastLogoutTime = time
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun getWarning(): JsonObject? {
        return WLCServerAccount.database.warnings.find { it.wid eq getWid() }?.warning
            ?.let { Gson().fromJson(it, JsonObject::class.java) }
    }

    fun addWarning(reason: String): Boolean {
        val warning = getWarning() ?: JsonObject()
        val newWarning = JsonObject().apply {
            addProperty("time", LocalDateTime.now().format(WLCServerAccount.dateTimeFormatter))
            addProperty("reason", reason)
        }
        warning.add((warning.size() + 1).toString(), newWarning)
        WLCServerAccount.database.warnings.find { it.wid eq getWid() }?.also {
            it.warning = warning.toString()
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun removeWarning(id: Int): Boolean {
        getWarning()?.remove(id.toString()) ?: throw NullPointerException("The account does not have any warnings")
        WLCServerAccount.database.warnings.find { it.wid eq getWid() }?.also {
            it.warning = warning.toString()
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun removeWarning(id: String): Boolean {
        getWarning()?.remove(id) ?: throw NullPointerException("The account does not have any warnings")
        WLCServerAccount.database.warnings.find { it.wid eq getWid() }?.also {
            it.warning = warning.toString()
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun isBanned(): Boolean {
        return WLCServerAccount.database.bans.find { it.wid eq getWid() }?.banned ?: false
    }

    fun ban(reason: String): Boolean {
        WLCServerAccount.database.bans.find { it.wid eq getWid() }?.also {
            it.banned = true
            it.time = LocalDateTime.now()
            it.reason = reason
            it.flushChanges()
        } ?: throw NullPointerException("The account does not exist")
        return true
    }

    fun unban(): Boolean {
        return WLCServerAccount.database.bans.find { it.wid eq getWid() }?.delete() == 1
    }

    fun isOnline(): Boolean {
        val player = WLCServerAccount.instance.proxyServer.getPlayer(getPlayerUniqueId())
        return if (player.isPresent) {
            player.get().isActive
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun disconnect(component: Component): Boolean {
        val player = WLCServerAccount.instance.proxyServer.getPlayer(getPlayerUniqueId())
        if (player.isPresent) {
            player.get().disconnect(component)
            return true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun disconnect(disconnectText: String): Boolean {
        val player = WLCServerAccount.instance.proxyServer.getPlayer(getPlayerUniqueId())
        if (player.isPresent) {
            player.get().disconnect(Component.text(disconnectText))
            return true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

}
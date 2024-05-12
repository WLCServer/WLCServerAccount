package cc.wlcs.wlcserveraccount.entity

import cc.wlcs.wlcserveraccount.WLCServerAccount
import cc.wlcs.wlcserveraccount.database.Account
import cc.wlcs.wlcserveraccount.database.Accounts.accounts
import com.velocitypowered.api.proxy.Player
import net.kyori.adventure.text.Component
import org.ktorm.dsl.*
import org.ktorm.entity.add
import org.ktorm.entity.find
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Optional
import java.util.UUID

data class Account(val wid: Int? = null, val name: String? = null, val uuid: UUID? = null) {

    fun exist(): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
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
        val identifier = when {
            wid != null -> wid
            name != null -> return name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.name ?: throw NullPointerException("The account does not exist")
    }

    fun setPlayerName(playerName: String): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        val account = WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }
        return if (account != null) {
            account.name = playerName
            account.flushChanges()
            true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun getPlayerUniqueId(): UUID {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> return uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return UUID.fromString(WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.uuid ?: throw NullPointerException("The account does not exist"))
    }

    fun setPlayerUniqueId(playerUniqueId: UUID): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        val account = WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }
        return if (account != null) {
            account.uuid = playerUniqueId.toString()
            account.flushChanges()
            true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun getGender(): String {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.gender ?: throw NullPointerException("The account does not exist")
    }

    fun setGender(gender: String): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        val account = WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }
        return if (account != null) {
            account.gender = gender
            account.flushChanges()
            true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun getQQ(): String? {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.qq
    }

    fun setQQ(qq: String): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        val account = WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }
        return if (account != null) {
            account.qq = qq
            account.flushChanges()
            true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun getEmail(): String? {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.email
    }

    fun setEmail(email: String): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        val account = WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }
        return if (account != null) {
            account.email = email
            account.flushChanges()
            true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun getPhone(): String? {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.phone
    }

    fun setPhone(phone: String): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        val account = WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }
        return if (account != null) {
            account.phone = phone
            account.flushChanges()
            true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun getBirthday(): LocalDate? {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.birthday
    }

    fun setBirthday(birthday: LocalDate): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        val account = WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }
        return if (account != null) {
            account.birthday = birthday
            account.flushChanges()
            true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun getRegisterIp(): String {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.registerIp ?: throw NullPointerException("The account does not exist")
    }

    fun setRegisterIp(ip: String): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        val account = WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }
        return if (account != null) {
            account.registerIp = ip
            account.flushChanges()
            true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun getRegisterTime(): LocalDateTime {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.registerTime ?: throw NullPointerException("The account does not exist")
    }

    fun setRegisterTime(time: LocalDateTime): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        val account = WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }
        return if (account != null) {
            account.registerTime = time
            account.flushChanges()
            true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun getLastLoginTime(): LocalDateTime {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.lastLoginTime ?: throw NullPointerException("The account does not exist")
    }

    fun setLastLoginTime(time: LocalDateTime): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        val account = WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }
        return if (account != null) {
            account.lastLoginTime = time
            account.flushChanges()
            true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun getLastLogoutTime(): LocalDateTime? {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        return WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }?.lastLogoutTime
    }

    fun setLastLogoutTime(time: LocalDateTime): Boolean {
        val identifier = when {
            wid != null -> wid
            name != null -> name
            uuid != null -> uuid
            else -> throw NullPointerException("id, name and uuid cannot all be null")
        }
        val account = WLCServerAccount.database.accounts.find {
            when (identifier) {
                is Int -> it.wid eq identifier
                is String -> it.name eq identifier
                is UUID -> it.uuid eq identifier.toString()
                else -> throw NullPointerException("id, name and uuid cannot all be null")
            }
        }
        return if (account != null) {
            account.lastLogoutTime = time
            account.flushChanges()
            true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun isOnline(): Boolean {
        var player = Optional.empty<Player>()
        if (wid != null) {
            player = WLCServerAccount.instance.proxyServer.getPlayer(getPlayerUniqueId())
        } else if (name != null) {
            player = WLCServerAccount.instance.proxyServer.getPlayer(name)
        } else if (uuid != null) {
            player = WLCServerAccount.instance.proxyServer.getPlayer(uuid)
        }
        return if (player.isPresent) {
            player.get().isActive
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

    fun disconnect(component: Component): Boolean {
        var player = Optional.empty<Player>()
        if (wid != null) {
            player = WLCServerAccount.instance.proxyServer.getPlayer(getPlayerUniqueId())
        } else if (name != null) {
            player = WLCServerAccount.instance.proxyServer.getPlayer(name)
        } else if (uuid != null) {
            player = WLCServerAccount.instance.proxyServer.getPlayer(uuid)
        }
        if (player.isPresent) {
            player.get().disconnect(component)
            return true
        } else {
            throw NullPointerException("The account does not exist")
        }
    }

}
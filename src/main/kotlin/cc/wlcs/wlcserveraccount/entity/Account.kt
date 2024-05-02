package cc.wlcs.wlcserveraccount.entity

import cc.wlcs.wlcserveraccount.Gender
import cc.wlcs.wlcserveraccount.WLCServerAccount
import cc.wlcs.wlcserveraccount.database.Account
import cc.wlcs.wlcserveraccount.database.Accounts.accounts
import com.velocitypowered.api.proxy.Player
import net.kyori.adventure.text.Component
import org.ktorm.dsl.*
import org.ktorm.entity.add
import org.ktorm.entity.find
import java.time.LocalDateTime
import java.util.UUID

data class Account(val id: Int? = null, val name: String? = null, val uuid: UUID? = null) {

    fun exist(): Boolean {
        if (name != null) {
            WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            } ?: return false
            return true
        } else if (uuid != null) {
            WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            } ?: return false
            return true
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun add(player: Player): Boolean {
        WLCServerAccount.instance.database.accounts
            .add(Account {
                name = player.username
                uuid = player.uniqueId.toString()
                registerIp = player.remoteAddress.hostName
                registerTime = LocalDateTime.now()
                lastLoginTime = LocalDateTime.now()
            })
        return true
    }

    fun getId(): Int {
       if (name != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            }!!.id
        } else if (uuid != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            }!!.id
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun getPlayerName(): String {
        if (name != null) {
            return name
        } else if (uuid != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            }!!.name
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun setPlayerName(playerName: String): Boolean {
        if (name != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            } ?: return false
            account.name = playerName
            account.flushChanges()
            return true
        } else if (uuid != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            } ?: return false
            account.name = playerName
            account.flushChanges()
            return true
        }
        return false
    }

    fun getPlayerUniqueId(): UUID {
        if (name != null) {
            return UUID.fromString(WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            }!!.uuid)
        } else if (uuid != null) {
            return uuid
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun setPlayerUniqueId(playerUniqueId: UUID): Boolean {
        if (name != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            } ?: return false
            account.uuid = playerUniqueId.toString()
            account.flushChanges()
            return true
        } else if (this.uuid != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            } ?: return false
            account.uuid = playerUniqueId.toString()
            account.flushChanges()
            return true
        }
        return false
    }

    fun getGender(): Gender {
        if (name != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            }!!.gender
        } else if (uuid != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            }!!.gender
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun setGender(gender: Gender): Boolean {
        if (name != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            } ?: return false
            account.gender = gender
            account.flushChanges()
            return true
        } else if (uuid != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            } ?: return false
            account.gender = gender
            account.flushChanges()
            return true
        }
        return false
    }

    fun getEmail(): String? {
        if (name != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            }?.email
        } else if (uuid != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            }?.email
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun setEmail(email: String): Boolean {
        if (name != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            } ?: return false
            account.email = email
            account.flushChanges()
            return true
        } else if (uuid != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            } ?: return false
            account.email = email
            account.flushChanges()
            return true
        }
        return false
    }

    fun getPhone(): String? {
        if (name != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            }?.phone
        } else if (uuid != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            }?.phone
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun setPhone(phone: String): Boolean {
        if (name != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            } ?: return false
            account.phone = phone
            account.flushChanges()
            return true
        } else if (uuid != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            } ?: return false
            account.phone = phone
            account.flushChanges()
            return true
        }
        return false
    }

    fun getRegisterIp(): String {
        if (name != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            }!!.registerIp
        } else if (uuid != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            }!!.registerIp
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun setRegisterIp(ip: String): Boolean {
        if (name != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            } ?: return false
            account.registerIp = ip
            account.flushChanges()
            return true
        } else if (uuid != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            } ?: return false
            account.registerIp = ip
            account.flushChanges()
            return true
        }
        return false
    }

    fun getRegisterTime(): LocalDateTime {
        if (name != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            }!!.registerTime
        } else if (uuid != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            }!!.registerTime
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun setRegisterTime(time: LocalDateTime): Boolean {
        if (name != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            } ?: return false
            account.registerTime = time
            account.flushChanges()
            return true
        } else if (uuid != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            } ?: return false
            account.registerTime = time
            account.flushChanges()
            return true
        }
        return false
    }

    fun getLastLoginTime(): LocalDateTime {
        if (name != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            }!!.lastLoginTime
        } else if (uuid != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            }!!.lastLoginTime
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun setLastLoginTime(time: LocalDateTime): Boolean {
        if (name != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            } ?: return false
            account.lastLoginTime = time
            account.flushChanges()
            return true
        } else if (uuid != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            } ?: return false
            account.lastLoginTime = time
            account.flushChanges()
            return true
        }
        return false
    }

    fun getLastLogoutTime(): LocalDateTime? {
        if (name != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            }?.lastLogoutTime
        } else if (uuid != null) {
            return WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            }?.lastLogoutTime
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun setLastLogoutTime(time: LocalDateTime): Boolean {
        if (name != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.name eq name
            } ?: return false
            account.lastLogoutTime = time
            account.flushChanges()
            return true
        } else if (uuid != null) {
            val account = WLCServerAccount.instance.database.accounts.find {
                it.uuid eq uuid.toString()
            } ?: return false
            account.lastLogoutTime = time
            account.flushChanges()
            return true
        }
        return false
    }

    fun getOnlineStatus(): Boolean {
        if (name != null) {
            val player = WLCServerAccount.instance.proxyServer.getPlayer(name)
            if (player.isPresent) {
                return player.get().isActive
            }
            return false
        } else if (uuid != null) {
            val player = WLCServerAccount.instance.proxyServer.getPlayer(uuid)
            if (player.isPresent) {
                return player.get().isActive
            }
            return false
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

    fun disconnect(component: Component): Boolean {
        if (name != null) {
            val player = WLCServerAccount.instance.proxyServer.getPlayer(name)
            if (player.isPresent) {
                player.get().disconnect(component)
                return true
            }
        } else if (uuid != null) {
            val player = WLCServerAccount.instance.proxyServer.getPlayer(uuid)
            if (player.isPresent) {
                player.get().disconnect(component)
                return true
            }
        }
        throw NullPointerException("name and uuid cannot both be null")
    }

}
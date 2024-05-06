package cc.wlcs.wlcserveraccount.database

import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.*

object Accounts : Table<Account>("account") {

    val Database.accounts get() = this.sequenceOf(Accounts)
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val uuid = varchar("uuid").bindTo { it.uuid }
    val gender = varchar("gender").bindTo { it.gender }
    val qq = varchar("qq").bindTo { it.qq }
    val email = varchar("email").bindTo { it.email }
    val phone = varchar("phone").bindTo { it.phone }
    val birthday = date("birthday").bindTo { it.birthday }
    val registerIp = varchar("register_ip").bindTo { it.registerIp }
    val registerTime = datetime("register_time").bindTo { it.registerTime }
    val lastLoginTime = datetime("lastlogin_time").bindTo { it.lastLoginTime }
    val lastLogoutTime = datetime("lastlogout_time").bindTo { it.lastLogoutTime }

}
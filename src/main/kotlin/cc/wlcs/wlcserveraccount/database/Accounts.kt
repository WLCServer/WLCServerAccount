package cc.wlcs.wlcserveraccount.database

import cc.wlcs.wlcserveraccount.Gender
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.*

object Accounts : Table<Account>("account") {

    val Database.accounts get() = this.sequenceOf(Accounts)
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val uuid = varchar("uuid").bindTo { it.uuid }
    val gender = enum<Gender>("gender").bindTo { it.gender }
    val email = varchar("email").bindTo { it.email }
    val phone = varchar("phone").bindTo { it.phone }
    val registerTime = datetime("register_time").bindTo { it.registerTime }
    val lastLoginTime = datetime("lastlogin_time").bindTo { it.lastLoginTime }
    val lastLogoutTime = datetime("lastlogout_time").bindTo { it.lastLogoutTime }

}
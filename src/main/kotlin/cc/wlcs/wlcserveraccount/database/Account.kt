package cc.wlcs.wlcserveraccount.database

import cc.wlcs.wlcserveraccount.Gender
import org.ktorm.entity.Entity
import java.time.LocalDateTime

interface Account : Entity<Account> {

    companion object : Entity.Factory<Account>()
    val id: Int
    var name: String
    var uuid: String
    var gender: Gender
    var qq: String?
    var email: String?
    var phone: String?
    var registerIp: String
    var registerTime: LocalDateTime
    var lastLoginTime: LocalDateTime
    var lastLogoutTime: LocalDateTime?

}
package cc.wlcs.wlcserveraccount.database

import org.ktorm.entity.Entity
import java.time.LocalDate
import java.time.LocalDateTime

interface Account : Entity<Account> {

    companion object : Entity.Factory<Account>()
    val id: Int
    var name: String
    var uuid: String
    var gender: String?
    var qq: String?
    var email: String?
    var phone: String?
    var birthday: LocalDate?
    var registerIp: String
    var registerTime: LocalDateTime
    var lastLoginTime: LocalDateTime
    var lastLogoutTime: LocalDateTime?

}
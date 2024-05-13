package cc.wlcs.wlcserveraccount.database

import org.ktorm.entity.Entity
import java.time.LocalDateTime

interface Ban : Entity<Ban> {

    companion object : Entity.Factory<Ban>()
    val wid: Int
    var name: String
    var uuid: String
    var banned: Boolean
    var time: LocalDateTime?
    var reason: String?

}
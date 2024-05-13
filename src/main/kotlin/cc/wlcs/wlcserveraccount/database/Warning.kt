package cc.wlcs.wlcserveraccount.database

import org.ktorm.entity.Entity

interface Warning : Entity<Warning> {

    companion object : Entity.Factory<Warning>()
    val wid: Int
    var name: String
    var uuid: String
    var warning: String?

}
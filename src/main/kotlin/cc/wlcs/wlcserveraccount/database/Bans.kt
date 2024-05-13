package cc.wlcs.wlcserveraccount.database

import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.*

object Bans: Table<Ban>("ban") {

    val Database.bans get() = this.sequenceOf(Bans)
    val wid = int("wid").primaryKey().bindTo { it.wid }
    val name = varchar("name").bindTo { it.name }
    val uuid = varchar("uuid").bindTo { it.uuid }
    val banned = boolean("banned").bindTo { it.banned }
    val time = datetime("time").bindTo { it.time }
    val reason = varchar("reason").bindTo { it.reason }

}
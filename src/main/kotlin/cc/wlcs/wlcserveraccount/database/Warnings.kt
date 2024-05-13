package cc.wlcs.wlcserveraccount.database

import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Warnings : Table<Warning>("warning") {

    val Database.warnings get() = this.sequenceOf(Warnings)
    val wid = int("wid").primaryKey().bindTo { it.wid }
    val name = varchar("name").bindTo { it.name }
    val uuid = varchar("uuid").bindTo { it.uuid }
    val warning = varchar("warning").bindTo { it.warning }

}
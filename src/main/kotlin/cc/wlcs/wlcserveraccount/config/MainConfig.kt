package cc.wlcs.wlcserveraccount.config

import space.arim.dazzleconf.annote.ConfDefault.DefaultString
import space.arim.dazzleconf.annote.ConfKey
import space.arim.dazzleconf.sorter.AnnotationBasedSorter.Order

interface MainConfig {

    @ConfKey("mysql.url")
    @DefaultString("jdbc:mysql://localhost:3306/wlcserveraccount")
    @Order(10)
    fun MysqlUrl(): String

    @ConfKey("mysql.user")
    @DefaultString("root")
    @Order(11)
    fun MysqlUser(): String

    @ConfKey("mysql.password")
    @DefaultString("password")
    @Order(12)
    fun MysqlPassword(): String
}